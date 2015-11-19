/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "adtransaction")
public class Transaction extends Audit {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "transaction_seq", sequenceName = "adtransaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    private long id;
    private long cableSystemId;
    private String description = "";
    @ManyToOne
    @JoinColumn(name = "holding_type_lkp")
    private HoldingType holdingType;
    @ManyToOne
    @JoinColumn(name = "transaction_type_lkp")
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name = "approval_status_lkp")
    private ApprovalStatus approvalStatus;
    @Column(name = "commitment_date")
    @Temporal(TemporalType.DATE)
    private Date commitmentDate;
    @Column(name = "stage_completion_date")
    @Temporal(TemporalType.DATE)
    private Date stageCompletionDate;
    @ManyToOne
    @JoinColumn(name = "completion_date_status_lkp")
    private CompletionDateStatus completionDateStatus;
    @ManyToOne
    @JoinColumn(name = "vodafone_entity_lkp")
    private VodafoneEntity vodafoneEntity;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "assignment_lkp")
    private FinanceType financeType;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @Column(name = "approved_spend")
    private BigDecimal approvedSpend;
    @Column(name = "term_months")
    private int term;
    @Column(name = "term_end_date")
    @Temporal(TemporalType.DATE)
    private Date termEndDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction", fetch = FetchType.EAGER)
    private List<TransactionCapacity> capacities;

    public boolean isNull() {
        return ((id == 0L) && (description.equals("")));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }

        Transaction other = (Transaction) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public String toString() {
        return description;
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
     * @return the description
     */
    public String getDescription() {
        return (description == null) ? "" : description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cableSystemId
     */
    public long getCableSystemId() {
        return cableSystemId;
    }

    /**
     * @param cableSystemId the cableSystemId to set
     */
    public void setCableSystemId(long cableSystemId) {
        this.cableSystemId = cableSystemId;
    }

    /**
     * @return the holdingType
     */
    public HoldingType getHoldingType() {
        return holdingType;
    }

    /**
     * @param holdingType the holdingType to set
     */
    public void setHoldingType(HoldingType holdingType) {
        this.holdingType = holdingType;
    }

    /**
     * @return the transactionType
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the approvalStatus
     */
    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * @param approvalStatus the approvalStatus to set
     */
    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * @return the commitmentDate
     */
    public Date getCommitmentDate() {
        return commitmentDate;
    }

    /**
     * @param commitmentDate the commitmentDate to set
     */
    public void setCommitmentDate(Date commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    /**
     * @return the stageCompletionDate
     */
    public Date getStageCompletionDate() {
        return stageCompletionDate;
    }

    /**
     * @param stageCompletionDate the stageCompletionDate to set
     */
    public void setStageCompletionDate(Date stageCompletionDate) {
        this.stageCompletionDate = stageCompletionDate;
    }

    /**
     * @return the completionDateStatus
     */
    public CompletionDateStatus getCompletionDateStatus() {
        return completionDateStatus;
    }

    /**
     * @param completionDateStatus the completionDateStatus to set
     */
    public void setCompletionDateStatus(CompletionDateStatus completionDateStatus) {
        this.completionDateStatus = completionDateStatus;
    }

    /**
     * @return the vodafoneEntity
     */
    public VodafoneEntity getVodafoneEntity() {
        return vodafoneEntity;
    }

    /**
     * @param vodafoneEntity the vodafoneEntity to set
     */
    public void setVodafoneEntity(VodafoneEntity vodafoneEntity) {
        this.vodafoneEntity = vodafoneEntity;
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
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project p) {
        project = (p != null && p.isNull()) ? null : p;
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
    public void setFinanceType(FinanceType ft) {
        financeType = (ft != null && ft.isNull()) ? null : ft;
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
     * @return the approvedSpend
     */
    public BigDecimal getApprovedSpend() {
        return approvedSpend;
    }

    /**
     * @param approvedSpend the approvedSpend to set
     */
    public void setApprovedSpend(BigDecimal approvedSpend) {
        this.approvedSpend = approvedSpend;
    }

    /**
     * @return the term
     */
    public int getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(int term) {
        this.term = term;
    }

    /**
     * @return the termEndDate
     */
    public Date getTermEndDate() {
        return termEndDate;
    }

    /**
     * @param termEndDate the termEndDate to set
     */
    public void setTermEndDate(Date termEndDate) {
        this.termEndDate = termEndDate;
    }

    /**
     * @return the capacities
     */
    public List<TransactionCapacity> getCapacities() {
        return capacities == null ? new ArrayList<TransactionCapacity>() : capacities;
    }

    /**
     * @param capacities the capacities to set
     */
    public void setCapacities(List<TransactionCapacity> capacities) {
        this.capacities = capacities;
    }

    public boolean isDisposal() {
        return (transactionType.getName().equals("Transfer Out") || transactionType.getName().equals("IRU Sale"));
    }
}
