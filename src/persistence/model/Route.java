/*
 * Class to provide provide and Entity mapping to the FPROUTE table.
 * This is for read only use only and just provides the atrributes needed.
 */
package persistence.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris Whiteley
 */
@Entity
@Table(name = "fproute")
public class Route implements Serializable, Comparable<Route> {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "fproute2fptag")
    private String tag;
    @ManyToOne
    @JoinColumn(name = "fproute2bandwidth")
    private Bandwidth bandwidth;
    @Column(name = "plannedstartdate")
    @Temporal(TemporalType.DATE)
    private Date plannedStartDate;
    @Column(name = "plannedenddate")
    @Temporal(TemporalType.DATE)
    private Date plannedEndDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "route_cable_capacity_v",
            joinColumns = {
        @JoinColumn(name = "route_id", referencedColumnName = "id")},
            inverseJoinColumns = {
        @JoinColumn(name = "cable_capacity_id", referencedColumnName = "id")})
    private Collection<CableCapacity> cableCapacities;

    /**
     * @return the name
     */
    public String getTag() {
        return (tag == null) ? "" : tag;
    }

    /**
     * @param name the name to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
//        return name + "|" + country.getName() + "|" + sites;
        return getTag();
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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Route)) {
            return false;
        }

        Route other = (Route) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public int compareTo(Route that) {
        return this.tag.compareTo(that.tag);
    }

    /**
     * @return the bandwidth
     */
    public Bandwidth getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(Bandwidth bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * @return the cableCapacities
     */
    public Collection<CableCapacity> getCableCapacities() {
        return cableCapacities;
    }

    /**
     * @param cableCapacities the cableCapacities to set
     */
    public void setCableCapacities(Collection<CableCapacity> cableCapacities) {
        this.cableCapacities = cableCapacities;
    }

    /**
     * @return the plannedStartDate
     */
    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    /**
     * @param plannedStartDate the plannedStartDate to set
     */
    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    /**
     * @return the plannedEndDate
     */
    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    /**
     * @param plannedEndDate the plannedEndDate to set
     */
    public void setPlannedEndDate(Date plannedenddate) {
        this.plannedEndDate = plannedenddate;
    }
}
