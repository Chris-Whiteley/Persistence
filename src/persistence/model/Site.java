/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity
@Table(name = "locationab")
public class Site extends Audit {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "sitename")
    private String name = "";
    @Column(name = "siteowner")
    private String owner;
    @Column(name = "address_line1")
    private String AddressLine1;
    @Column(name = "address_line2")
    private String AddressLine2;
    private String postcode;
    private String region;
    @Column(name = "grid_reference")
    private String gridReference;
    @Column(name = "mori_code")
    private String moriCode;
    @Column(name = "known_as")
    private String knownAs;
    private String deprecated;
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id")
    private City city;
    private String planned;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the AddressLine1
     */
    public String getAddressLine1() {
        return AddressLine1;
    }

    /**
     * @param AddressLine1 the AddressLine1 to set
     */
    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    /**
     * @return the AddressLine2
     */
    public String getAddressLine2() {
        return AddressLine2;
    }

    /**
     * @param AddressLine2 the AddressLine2 to set
     */
    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return city.getCountry();
    }

    /**
     * @return the gridReference
     */
    public String getGridReference() {
        return gridReference;
    }

    /**
     * @param gridReference the gridReference to set
     */
    public void setGridReference(String gridReference) {
        this.gridReference = gridReference;
    }

    /**
     * @return the moriCode
     */
    public String getMoriCode() {
        return moriCode;
    }

    /**
     * @param moriCode the moriCode to set
     */
    public void setMoriCode(String moriCode) {
        this.moriCode = moriCode;
    }

    /**
     * @return the knownAs
     */
    public String getKnownAs() {
        return knownAs;
    }

    /**
     * @param knownAs the knownAs to set
     */
    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    /**
     * @return the deprecated
     */
    public boolean isDeprecated() {
        if (deprecated == null) {
            return false;
        }
        return deprecated.equalsIgnoreCase("Y");
    }

    /**
     * @return the deprecated
     */
    public String deprecatedFlag() {
        if (deprecated == null) {
            return "X";
        }
        return deprecated;
    }

    /**
     * @param deprecated the deprecated to set
     */
    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated ? "Y" : "N";
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    public boolean isPlanned() {
        return (planned == null) ? false : planned.equals("Y");
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isNull() {
        return ((id == 0L) && (name.length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Site)) {
            return false;
        }

        Site other = (Site) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }
}
