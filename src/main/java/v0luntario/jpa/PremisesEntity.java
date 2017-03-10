package v0luntario.jpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by silvo on 3/10/17.
 */
@Entity
@Table(name = "premises", schema = "v0luntario")
public class PremisesEntity {
    private String premiseId;
    private String description;
    private byte[] attachment;
    private byte[] attachment2;
    private byte[] attachment3;
    private Collection<MovementsEntity> movementssByPremiseId;

    @Id
    @Column(name = "premise_id")
    public String getPremiseId() {
        return premiseId;
    }

    public void setPremiseId(String premiseId) {
        this.premiseId = premiseId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "attachment")
    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    @Basic
    @Column(name = "attachment2")
    public byte[] getAttachment2() {
        return attachment2;
    }

    public void setAttachment2(byte[] attachment2) {
        this.attachment2 = attachment2;
    }

    @Basic
    @Column(name = "attachment3")
    public byte[] getAttachment3() {
        return attachment3;
    }

    public void setAttachment3(byte[] attachment3) {
        this.attachment3 = attachment3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremisesEntity that = (PremisesEntity) o;

        if (premiseId != null ? !premiseId.equals(that.premiseId) : that.premiseId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!Arrays.equals(attachment, that.attachment)) return false;
        if (!Arrays.equals(attachment2, that.attachment2)) return false;
        if (!Arrays.equals(attachment3, that.attachment3)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = premiseId != null ? premiseId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(attachment);
        result = 31 * result + Arrays.hashCode(attachment2);
        result = 31 * result + Arrays.hashCode(attachment3);
        return result;
    }

    @OneToMany(mappedBy = "premisesByPremiseId")
    public Collection<MovementsEntity> getMovementssByPremiseId() {
        return movementssByPremiseId;
    }

    public void setMovementssByPremiseId(Collection<MovementsEntity> movementssByPremiseId) {
        this.movementssByPremiseId = movementssByPremiseId;
    }
}
