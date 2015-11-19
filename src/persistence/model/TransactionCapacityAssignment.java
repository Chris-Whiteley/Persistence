/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@IdClass(TransactionCapacityAssignmentPk.class)
@Entity
@Table(name = "trans_capacity_assignment")
public class TransactionCapacityAssignment extends Audit {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "transaction_capacity_id")
    private long transactionCapacityId;
    @Id
    @Column(name = "cable_capacity_id")
    private long cableCapacityId;
    private BigDecimal capacity;
    @ManyToOne
    @JoinColumn(name = "transaction_capacity_id", updatable = false, insertable = false)
    private TransactionCapacity transactionCapacity;
    @ManyToOne
    @JoinColumn(name = "cable_capacity_id", updatable = false, insertable = false)
    private CableCapacity cableCapacity;

    public boolean isNull() {
        return (getTransactionCapacityId() == 0L);
    }

    @Override
    public String toString() {
        return (getTransactionCapacity() == null) ? "" : getTransactionCapacity().toString();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getTransactionCapacityId()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransactionCapacityAssignment)) {
            return false;
        }
        TransactionCapacityAssignment pk = (TransactionCapacityAssignment) obj;
        return (pk.getTransactionCapacityId() == getTransactionCapacityId()) && (pk.getCableCapacityId() == getCableCapacityId());
    }

    /**
     * @return the transactionCapacityId
     */
    public long getTransactionCapacityId() {
        return transactionCapacityId;
    }

    /**
     * @param transactionCapacityId the transactionCapacityId to set
     */
    public void setTransactionCapacityId(long transactionCapacityId) {
        this.transactionCapacityId = transactionCapacityId;
    }

    /**
     * @return the cableCapacityId
     */
    public long getCableCapacityId() {
        return cableCapacityId;
    }

    /**
     * @param cableCapacityId the cableCapacityId to set
     */
    public void setCableCapacityId(long cableCapacityId) {
        this.cableCapacityId = cableCapacityId;
    }

    /**
     * @return the capacity
     */
    public BigDecimal getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the transactionCapacity
     */
    public TransactionCapacity getTransactionCapacity() {
        return transactionCapacity;
    }

    /**
     * @param transactionCapacity the transactionCapacity to set
     */
    public void setTransactionCapacity(TransactionCapacity transactionCapacity) {
        this.transactionCapacity = transactionCapacity;
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
