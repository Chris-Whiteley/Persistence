/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Chris Whiteley
 */
@MappedSuperclass
@Access(value = AccessType.FIELD)
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    private static String currentUser = "Falcon User";
    private String modifiedBy;
    private Date modifiedDate;
    private long changeNo = 0L;  //needs to be 0 for persistence to detect new record!

    /**
     * @return the modifiedBy
     */
    @Column(name = "modifiedby")
    @Access(value = AccessType.PROPERTY)
    public String getModifiedBy() {
        return (modifiedBy == null) ? modifiedBy = currentUser : modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedDate
     */
    @Column(name = "modifiedDATE")
    @Access(value = AccessType.PROPERTY)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getModifiedDate() {
        return (modifiedDate == null) ? modifiedDate = new Date() : modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Sets modifiedDate to the current date.
     */
    public void setModifiedDate() {
        this.modifiedDate = new Date();
    }

    /**
     * @return the changeNo
     */
    @Version
    @Column(name = "Change_No")
    @Access(value = AccessType.PROPERTY)
    public long getChangeNo() {
        return changeNo;
    }

    /**
     * @param changeNo the changeNo to set
     */
    public void setChangeNo(long changeNo) {
        this.changeNo = changeNo;
    }

    /**
     * Used to set the auditing files modifiedBy and modifiedDate. ChangeNo
     * field is set up automatically by EclipseLink
     */
    public void setAudit() {
        modifiedBy = currentUser;
        setModifiedDate();
    }

    /**
     * @param aCurrentUser the currentUser to set
     */
    public static void setCurrentUser(String aCurrentUser) {
        currentUser = aCurrentUser;
    }
}
