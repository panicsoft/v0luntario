package v0luntario.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "groups", schema = "v0luntario")
public class GroupsEntity {
    private String groupId;
    private String groupName;
    private String description;
    private Collection<UserGroupEntity> userGroupsByGroupId;

    @Id
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

        GroupsEntity that = (GroupsEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "groupsByGroupId")
    public Collection<UserGroupEntity> getUserGroupsByGroupId() {
        return userGroupsByGroupId;
    }

    public void setUserGroupsByGroupId(Collection<UserGroupEntity> userGroupsByGroupId) {
        this.userGroupsByGroupId = userGroupsByGroupId;
    }
}
