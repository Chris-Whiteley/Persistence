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
public class CableSystemNodePk implements Serializable {

    private static final long serialVersionUID = 1L;
    private long cableSystemId;
    private long nodeId;

    public CableSystemNodePk() {
    }

    public CableSystemNodePk(long csId, long nId) {
        cableSystemId = csId;
        nodeId = nId;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(nodeId).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CableSystemNodePk)) {
            return false;
        }
        CableSystemNodePk pk = (CableSystemNodePk) obj;
        return (pk.cableSystemId == cableSystemId) && (pk.nodeId == nodeId);
    }
}
