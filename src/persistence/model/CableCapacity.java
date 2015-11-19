package persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity
@Table(name = "cable_capacity")
public class CableCapacity extends Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "cable_capacity_seq", sequenceName = "cable_capacity_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cable_capacity_seq")
    private long id;
    @ManyToOne
    @JoinColumn(name = "path_id")
    private Path path;
    @ManyToOne
    @JoinColumn(name = "assignment_lkp")
    private FinanceType financeType;
    @ManyToOne
    @JoinColumn(name = "allocation_lkp")
    private CapacityAllocation capacityAllocation;
    @ManyToOne
    @JoinColumn(name = "bandwidth_id")
    private Bandwidth bandwidth;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "investment_unit_lkp")
    private InvestmentUnit investmentUnit;
    @ManyToOne
    @JoinColumn(name = "whole_or_joint_lkp")
    private WholeOrJoint wholeOrJoint;
    @ManyToOne
    @JoinColumn(name = "matching_party_id")
    private Supplier matchingParty;
    @ManyToMany(mappedBy = "cableCapacities", fetch = FetchType.EAGER)
    private List<Route> routes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cableCapacity", fetch = FetchType.EAGER)
    private List<TransactionCapacityAssignment> capacityUsage;

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
        if (!(o instanceof CableCapacity)) {
            return false;
        }

        CableCapacity other = (CableCapacity) o;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
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
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * @return the financeType
     */
    public FinanceType getFinanceType() {
        return financeType;
    }

    /**
     * @param financeType the financeType to set
     */
    public void setFinanceType(FinanceType financeType) {
        this.financeType = financeType;
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
    public void setCapacityAllocation(CapacityAllocation ca) {
        capacityAllocation = (ca != null && ca.isNull()) ? null : ca;
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
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier s) {
        supplier = (s != null && s.isNull()) ? null : s;
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
     * @return the wholeOrJoint
     */
    public WholeOrJoint getWholeOrJoint() {
        return wholeOrJoint;
    }

    /**
     * @param wholeOrJoint the wholeOrJoint to set
     */
    public void setWholeOrJoint(WholeOrJoint wholeOrJoint) {
        this.wholeOrJoint = wholeOrJoint;
    }

    /**
     * @return the matchingParty
     */
    public Supplier getMatchingParty() {
        return matchingParty;
    }

    /**
     * @param matchingParty the matchingParty to set
     */
    public void setMatchingParty(Supplier s) {
        matchingParty = (s != null && s.isNull()) ? null : s;
    }

    /**
     * @return the routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * @param routes the routes to set
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    /**
     * @return the capacity
     */
    public BigDecimal getCapacity() {
        BigDecimal capacity = new BigDecimal("0");

        for (TransactionCapacityAssignment assigned : getCapacityUsage()) {
            capacity = capacity.add(assigned.getCapacity());
        }

        return capacity;
    }

    /**
     * @return the capacityUsage
     */
    public List<TransactionCapacityAssignment> getCapacityUsage() {
        return (capacityUsage == null) ? capacityUsage = new ArrayList<TransactionCapacityAssignment>() : capacityUsage;
    }

    /**
     * @param capacityUsage the capacityUsage to set
     */
    public void setCapacityUsage(List<TransactionCapacityAssignment> capacityUsage) {
        this.capacityUsage = capacityUsage;
    }
}
