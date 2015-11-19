/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Chris Whiteley
 */
@Entity
//@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "city_seq", sequenceName = "city_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    private long id;
    private String name = "";
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_lkp")
    private LocationRegion region;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_lkp")
    private Country country;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Collection<Site> sites;
    private String planned;

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
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the sites
     */
    public Collection<Site> getSites() {
        //   return (sites == null) ? sites = new ArrayList<Site>() : sites;

        if (sites == null) {
            return new ArrayList<Site>();
        }

        Collection<Site> nonDepricated = new ArrayList<Site>();

        for (Site site : sites) {
            if (!site.isDeprecated()) {
                nonDepricated.add(site);
            }
        }

        return nonDepricated;

    }

    /**
     * @return the sites
     */
    public Collection<Site> getRealSites() {
        //   return (sites == null) ? sites = new ArrayList<Site>() : sites;

        if (sites == null) {
            return new ArrayList<Site>();
        }

        Collection<Site> nonDepricated = new ArrayList<Site>();

        for (Site site : sites) {
            if (!site.isDeprecated()) {
                nonDepricated.add(site);
            }
        }

        return nonDepricated;

    }

    /**
     * @param sites the sites to set
     */
    public void setSites(Collection<Site> sites) {
        this.sites = sites;
    }

    @Override
    public String toString() {
//        return name + "|" + country.getName() + "|" + sites;
        return name;
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
     * @return the region
     */
    public LocationRegion getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(LocationRegion region) {
        this.region = region;
    }

    public boolean isPlanned() {
        return (planned == null) ? false : planned.equals("Y");
    }

    public boolean isNull() {
        return ((id == 0L) && (name.length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof City)) {
            return false;
        }

        City other = (City) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }
}
