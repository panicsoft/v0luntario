package v0luntario.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "classes", schema = "v0luntario")
public class ClassesEntity {
    private String classId;
    private String name;
    private String description;
    private Collection<ProductsEntity> productssByClassId;

    @Id
    @Column(name = "class_id")
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassesEntity that = (ClassesEntity) o;

        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId != null ? classId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "classesByClassId")
    public Collection<ProductsEntity> getProductssByClassId() {
        return productssByClassId;
    }

    public void setProductssByClassId(Collection<ProductsEntity> productssByClassId) {
        this.productssByClassId = productssByClassId;
    }
}
