package v0luntario.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "users", schema = "v0luntario")
public class UsersEntity {
    private String userId;
    private String username;
    private Serializable role;
    private String createdBy;
    private String email;
    private String passwordHash;
    private Timestamp lastLogin;
    private Collection<MovementsEntity> movementssByUserId;
    private Collection<ProductsEntity> productssByUserId;
    private Collection<StashEntity> stashesByUserId;
    private Collection<UserGroupEntity> userGroupsByUserId;
    private UserdetailsEntity userdetailsByUserId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "role")
    public Serializable getRole() {
        return role;
    }

    public void setRole(Serializable role) {
        this.role = role;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "last_login")
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passwordHash != null ? !passwordHash.equals(that.passwordHash) : that.passwordHash != null) return false;
        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<MovementsEntity> getMovementssByUserId() {
        return movementssByUserId;
    }

    public void setMovementssByUserId(Collection<MovementsEntity> movementssByUserId) {
        this.movementssByUserId = movementssByUserId;
    }

    @OneToMany(mappedBy = "usersByAddedBy")
    public Collection<ProductsEntity> getProductssByUserId() {
        return productssByUserId;
    }

    public void setProductssByUserId(Collection<ProductsEntity> productssByUserId) {
        this.productssByUserId = productssByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<StashEntity> getStashesByUserId() {
        return stashesByUserId;
    }

    public void setStashesByUserId(Collection<StashEntity> stashesByUserId) {
        this.stashesByUserId = stashesByUserId;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<UserGroupEntity> getUserGroupsByUserId() {
        return userGroupsByUserId;
    }

    public void setUserGroupsByUserId(Collection<UserGroupEntity> userGroupsByUserId) {
        this.userGroupsByUserId = userGroupsByUserId;
    }

    @OneToOne(mappedBy = "usersByUserId")
    public UserdetailsEntity getUserdetailsByUserId() {
        return userdetailsByUserId;
    }

    public void setUserdetailsByUserId(UserdetailsEntity userdetailsByUserId) {
        this.userdetailsByUserId = userdetailsByUserId;
    }
}
