/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "fauser")
public class User extends Audit implements Comparable<User> {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    private long id;
    private long planRegionId;
    private String surname = "";
    private String firstname = "";
    private String initials;
    private String phonenumber;
    private String email;
    private long businessunitid;
    private String location;
    @Column(name = "active")
    private String active_yn;
    @Column(name = "change_no")
    private long changeNo;
    private String staffno = "";
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_v",
            joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Collection<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User other = (User) o;

        if (this.id == 0) {
            return (other.id == 0);
        }

        if (other.id == 0) {
            return false;
        }

        // should have non null values for staffno, fistname, and surname
        // no staffno can be null... is this correct?

        //System.out.println("this" + this.staffno);
        //System.out.println("other" + other.staffno);

        if (this.staffno == null && other.staffno != null) {
            return false;
        }

        if (this.staffno != null && other.staffno == null) {
            return false;
        }

        if (this.staffno != null) {
            if (!this.staffno.equalsIgnoreCase(other.staffno)) {
                return false;
            }
        }

        if (!this.firstname.equalsIgnoreCase(other.firstname)) {
            return false;
        }
        if (!this.surname.equalsIgnoreCase(other.surname)) {
            return false;
        }

        return true;
    }

    public int hashCode(Object o) {
        return (int) staffno.hashCode()
                * firstname.hashCode()
                * surname.hashCode();
    }

    @Override
    /**
     * Set natural sort order of first name then surname
     */
    public int compareTo(User uThat) {
        final int EQUAL = 0;

        if (this == uThat) {
            return EQUAL;
        }

        int comparison = this.firstname.compareToIgnoreCase(uThat.firstname);
        if (comparison != EQUAL) {
            return comparison;
        }

        comparison = this.surname.compareToIgnoreCase(uThat.surname);
        if (comparison != EQUAL) {
            return comparison;
        }

        return EQUAL;
    }

    @Override
    public String toString() {
        return firstname + " " + surname;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the planRegionId
     */
    public long getPlanRegionId() {
        return planRegionId;
    }

    /**
     * @param planRegionId the planRegionId to set
     */
    public void setPlanRegionId(long planRegionId) {
        this.planRegionId = planRegionId;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the businessuinitid
     */
    public long getBusinessunitid() {
        return businessunitid;
    }

    /**
     * @param businessuinitid the businessuinitid to set
     */
    public void setBusinessunitid(long businessunitid) {
        this.businessunitid = businessunitid;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        if (active_yn == null) {
            return false;
        }
        return active_yn.equalsIgnoreCase("Y");
    }

    /**
     * @param active is the active to set
     */
    public void setActive(boolean active) {
        active_yn = active ? "Y" : "N";
    }

    /**
     * @return the changeNo
     */
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
     * @return the staffno
     */
    public String getStaffno() {
        return staffno;
    }

    /**
     * @param staffno the staffno to set
     */
    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    /**
     * @return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isNull() {
        return ((id == 0L) && (surname.length() == 0));
    }
}
