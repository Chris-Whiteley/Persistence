/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "transaction_capacity")
public class TransactionCapacity extends Audit {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "trans_capacity_seq", sequenceName = "transaction_capacity_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trans_capacity_seq")
    private long id;
    @ManyToOne
    @JoinColumn(name = "transactionid")
    private Transaction transaction;
    @ManyToOne
    @JoinColumn(name = "capacity_type_lkp")
    private TransactionCapacityType capacityType;
    @ManyToOne
    @JoinColumn(name = "investment_unit_lkp")
    private InvestmentUnit investmentUnit;
    @ManyToOne
    @JoinColumn(name = "allocation_lkp")
    private CapacityAllocation capacityAllocation;
    @ManyToOne
    @JoinColumn(name = "bandwidth_id")
    private Bandwidth bandwidth;
    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;
    @ManyToOne
    @JoinColumn(name = "path_id")
    private Path path;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @Column(name = "cost_per_unit")
    private BigDecimal unitCost;
    private BigDecimal quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionCapacity", fetch = FetchType.EAGER)
    private List<TransactionCapacityAssignment> capacityAssignments;

    public boolean isNull() {
        return ((getId() == 0L) && (getTransaction() == null));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof TransactionCapacity)) {
            return false;
        }

        TransactionCapacity other = (TransactionCapacity) o;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
    }

    @Override
    public String toString() {
        return Long.toString(getId()) + '|' + getCapacityType() + '|' + getInvestmentUnit() + '|' + getSegment() + '|' + getPath();
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
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * @return the capacityType
     */
    public TransactionCapacityType getCapacityType() {
        return capacityType;
    }

    /**
     * @param capacityType the capacityType to set
     */
    public void setCapacityType(TransactionCapacityType capacityType) {
        this.capacityType = capacityType;
    }

    /**
     * @return the investmentUnit
     */
    public InvestmentUnit getInvestmentUnit() {
        return investmentUnit;
    }

    /**
     * @param investmentUnit the investmentUnit to set
     */
    public void setInvestmentUnit(InvestmentUnit investmentUnit) {
        this.investmentUnit = investmentUnit;
    }

    /**
     * @return the capacityAllocation
     */
    public CapacityAllocation getCapacityAllocation() {
        return capacityAllocation;
    }

    /**
     * @param capacityAllocation the capacityAllocation to set
     */
    public void setCapacityAllocation(CapacityAllocation capacityAllocation) {
        this.capacityAllocation = capacityAllocation;
    }

    /**
     * @return the segment
     */
    public Segment getSegment() {
        return segment;
    }

    /**
     * @param segment the segment to set
     */
    public void setSegment(Segment s) {
        segment = (s != null && s.isNull()) ? null : s;
    }

    /**
     * @return the path
     */
    public Path getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(Path p) {
        path = (p != null && p.isNull()) ? null : p;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the unitCost
     */
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    /**
     * @param unitCost the unitCost to set
     */
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Object getPathOrSegment() {
        // Determined by value of Investment Unit
        Object pathOrSegment = null;

        if (investmentUnit != null) {
            if (investmentUnit.getName().equals("Path")) {
                pathOrSegment = path;
            } else if (investmentUnit.getName().equals("Segment")) {
                pathOrSegment = segment;
            }
        }
        return pathOrSegment;
    }

    public void setPathOrSegment(Object o) {
        if (o instanceof Segment) {
            setSegment((Segment) o);
            setPath(null);
        } else if (o instanceof Path) {
            setPath((Path) o);
            setSegment(null);
        } else {
            setPath(null);
            setSegment(null);
        }

    }

    public BigDecimal getSubTotal() {
        BigDecimal subTotal = quantity.multiply(unitCost);
        return (transaction.isDisposal()) ? subTotal.negate() : subTotal;
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
     * @return the capacityAssignments
     */
    public List<TransactionCapacityAssignment> getCapacityAssignments() {
        return capacityAssignments;
    }

    /**
     * @param capacityAssignments the capacityAssignments to set
     */
    public void setCapacityAssignments(List<TransactionCapacityAssignment> capacityAssignments) {
        this.capacityAssignments = capacityAssignments;
    }

    public BigDecimal getAvailableCapacity() {
        BigDecimal availableCapacity = new BigDecimal("0");

        if (!transaction.isDisposal()) {
            availableCapacity = getQuantity();

            // deduct any assigned capacity from the quantity
            for (TransactionCapacityAssignment assignment : capacityAssignments) {
                availableCapacity = availableCapacity.subtract(assignment.getCapacity());
            }
        }

        return availableCapacity;
    }
}
