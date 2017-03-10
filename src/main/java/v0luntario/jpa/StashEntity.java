package v0luntario.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "stash", schema = "v0luntario")
@IdClass(StashEntityPK.class)
public class StashEntity {
    private String prodId;
    private String userId;
    private BigDecimal amount;
    private BigDecimal requiredAmount;
    private Serializable active;
    private Timestamp deadline;
    private ProductsEntity productsByProdId;
    private UsersEntity usersByUserId;

    @Id
    @Column(name = "prod_id")
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    @Column(name = "required_amount")
    public BigDecimal getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(BigDecimal requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    @Basic
    @Column(name = "active")
    public Serializable getActive() {
        return active;
    }

    public void setActive(Serializable active) {
        this.active = active;
    }

    @Basic
    @Column(name = "deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StashEntity that = (StashEntity) o;

        if (prodId != null ? !prodId.equals(that.prodId) : that.prodId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (requiredAmount != null ? !requiredAmount.equals(that.requiredAmount) : that.requiredAmount != null)
            return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodId != null ? prodId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (requiredAmount != null ? requiredAmount.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
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
}
