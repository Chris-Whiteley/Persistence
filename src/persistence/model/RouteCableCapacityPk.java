/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;

/**
 *
 * @author Chris Whiteley
 */
public class RouteCableCapacityPk implements Serializable {

    private static final long serialVersionUID = 1L;
    private long routeId;
    private long segmentId;

    public RouteCableCapacityPk() {
    }

    public RouteCableCapacityPk(long rteId, long segId) {
        routeId = rteId;
        segmentId = segId;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(segmentId).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteCableCapacityPk)) {
            return false;
        }
        RouteCableCapacityPk pk = (RouteCableCapacityPk) obj;
        return (pk.routeId == routeId) && (pk.segmentId == segmentId);
    }
}
