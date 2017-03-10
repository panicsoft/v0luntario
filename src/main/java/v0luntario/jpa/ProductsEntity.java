package v0luntario.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "products", schema = "v0luntario")
public class ProductsEntity {
    private String prodId;
    private String name;
    private String description;
    private Collection<MovementsEntity> movementssByProdId;
    private ClassesEntity classesByClassId;
    private UnitsEntity unitsByUnitId;
    private UsersEntity usersByAddedBy;
    private Collection<StashEntity> stashesByProdId;

    @Id
    @Column(name = "prod_id")
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
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

        ProductsEntity that = (ProductsEntity) o;

        if (prodId != null ? !prodId.equals(that.prodId) : that.prodId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodId != null ? prodId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productsByProdId")
    public Collection<MovementsEntity> getMovementssByProdId() {
        return movementssByProdId;
    }

    public void setMovementssByProdId(Collection<MovementsEntity> movementssByProdId) {
        this.movementssByProdId = movementssByProdId;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    public ClassesEntity getClassesByClassId() {
        return classesByClassId;
    }

    public void setClassesByClassId(ClassesEntity classesByClassId) {
        this.classesByClassId = classesByClassId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false)
    public UnitsEntity getUnitsByUnitId() {
        return unitsByUnitId;
    }

    public void setUnitsByUnitId(UnitsEntity unitsByUnitId) {
        this.unitsByUnitId = unitsByUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "added_by", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByAddedBy() {
        return usersByAddedBy;
    }

    public void setUsersByAddedBy(UsersEntity usersByAddedBy) {
        this.usersByAddedBy = usersByAddedBy;
    }

    @OneToMany(mappedBy = "productsByProdId")
    public Collection<StashEntity> getStashesByProdId() {
        return stashesByProdId;
    }

    public void setStashesByProdId(Collection<StashEntity> stashesByProdId) {
        this.stashesByProdId = stashesByProdId;
    }
}
