package v0luntario.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "units", schema = "v0luntario")
public class UnitsEntity {
    private String unitId;
    private String name;
    private Collection<ProductsEntity> productssByUnitId;

    @Id
    @Column(name = "unit_id")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitsEntity that = (UnitsEntity) o;

        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId != null ? unitId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "unitsByUnitId")
    public Collection<ProductsEntity> getProductssByUnitId() {
        return productssByUnitId;
    }

    public void setProductssByUnitId(Collection<ProductsEntity> productssByUnitId) {
        this.productssByUnitId = productssByUnitId;
    }
}
