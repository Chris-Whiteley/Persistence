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
public class TransactionCapacityAssignmentPk implements Serializable {

    private static final long serialVersionUID = 1L;
    private long transactionCapacityId;
    private long cableCapacityId;

    public TransactionCapacityAssignmentPk() {
    }

    public TransactionCapacityAssignmentPk(long tcId, long ccId) {
        transactionCapacityId = tcId;
        cableCapacityId = ccId;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(transactionCapacityId).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransactionCapacityAssignmentPk)) {
            return false;
        }
        TransactionCapacityAssignmentPk pk = (TransactionCapacityAssignmentPk) obj;
        return (pk.transactionCapacityId == transactionCapacityId) && (pk.cableCapacityId == cableCapacityId);
    }
}
