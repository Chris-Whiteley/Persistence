/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@IdClass(RouteCableCapacityPk.class)
@Entity
@Table(name = "fproutesegment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "fproutesegment2routesegtypelkp", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(RouteCableCapacity.CABLE_CAPACITY_SEGMENT_TYPE)
public class RouteCableCapacity extends Audit {
    // falookup id for segment type of Cable Capacity.

    public static final String CABLE_CAPACITY_SEGMENT_TYPE = "119022";
    private static final long serialVersionUID = 1L;
    @Id
    private long routeId;
    @Id
    private long segmentId;
    @Column(name = "comments")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "fproutesegment2fproute", updatable = false, insertable = false)
    private Route route;
    @ManyToOne
    @JoinColumn(name = "fproutesegment2uniquerefid", updatable = false, insertable = false)
    private CableCapacity cableCapacity;

    public boolean isNull() {
        return (getRouteId() == 0L);
    }

    @Override
    public String toString() {
        return (getCableCapacity() == null) ? "" : getCableCapacity().toString();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getSegmentId()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteCableCapacity)) {
            return false;
        }
        RouteCableCapacity pk = (RouteCableCapacity) obj;
        return (pk.getRouteId() == getRouteId()) && (pk.getSegmentId() == getSegmentId());
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return (comment == null) ? "" : comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the routeId
     */
    public long getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the routeId to set
     */
    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the segmentId
     */
    public long getSegmentId() {
        return segmentId;
    }

    /**
     * @param segmentId the segmentId to set
     */
    public void setSegmentId(long segmentId) {
        this.segmentId = segmentId;
    }

    /**
     * @return the route
     */
    public Route getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * @return the cableCapacity
     */
    public CableCapacity getCableCapacity() {
        return cableCapacity;
    }

    /**
     * @param cableCapacity the cableCapacity to set
     */
    public void setCableCapacity(CableCapacity cableCapacity) {
        this.cableCapacity = cableCapacity;
    }
}
