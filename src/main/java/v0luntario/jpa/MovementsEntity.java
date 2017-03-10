package v0luntario.jpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "movements", schema = "v0luntario")
public class MovementsEntity {
    private String moveId;
    private BigDecimal amount;
    private Timestamp motionDate;
    private ProductsEntity productsByProdId;
    private UsersEntity usersByUserId;
    private PremisesEntity premisesByPremiseId;

    @Id
    @Column(name = "move_id")
    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "motion_date")
    public Timestamp getMotionDate() {
        return motionDate;
    }

    public void setMotionDate(Timestamp motionDate) {
        this.motionDate = motionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovementsEntity that = (MovementsEntity) o;

        if (moveId != null ? !moveId.equals(that.moveId) : that.moveId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (motionDate != null ? !motionDate.equals(that.motionDate) : that.motionDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moveId != null ? moveId.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (motionDate != null ? motionDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id", nullable = false)
    public ProductsEntity getProductsByProdId() {
        return productsByProdId;
    }

    public void setProductsByProdId(ProductsEntity productsByProdId) {
        this.productsByProdId = productsByProdId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "premise_id", referencedColumnName = "premise_id", nullable = false)
    public PremisesEntity getPremisesByPremiseId() {
        return premisesByPremiseId;
    }

    public void setPremisesByPremiseId(PremisesEntity premisesByPremiseId) {
        this.premisesByPremiseId = premisesByPremiseId;
    }
}
