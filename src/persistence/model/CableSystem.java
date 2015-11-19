/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.util.Date;
import java.util.ArrayList;
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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "adcablesystem")
public class CableSystem extends Audit {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "cablesystem_seq", sequenceName = "adcablesystem_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cablesystem_seq")
    private long id;
    private String name;
    private String code;
    private String url = "";
    @ManyToOne
    @JoinColumn(name = "commercial_model_lkp")
    private CommercialModel commercialModel;
    @ManyToOne
    @JoinColumn(name = "trans_path_lkp")
    private TransmissionPath transmissionPath;
    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "integer", name = "owner_lkp", nullable = true)
    private Operator operator;
    @ManyToOne
    @JoinColumn(name = "region_lkp")
    private CableSystemRegion region;
    @ManyToOne
    @JoinColumn(name = "status_lkp")
    private CableSystemStatus status;
    @ManyToOne(optional = true)
    @JoinColumn(columnDefinition = "integer", name = "miu_lkp", nullable = true)
    private MinimumInvestmentUnit minimumInvestmentUnit;
    @ManyToOne
    @JoinColumn(name = "activation_lkp")
    private ActivationUnit activationUnit;
    private String description = "";
    @Column(name = "terminating_countries")
    private String terminatingCountries;
    @Column(name = "in_service_date")
    @Temporal(TemporalType.DATE)
    private Date inServiceDate;
    @Column(name = "retirement_date")
    @Temporal(TemporalType.DATE)
    private Date retirementDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cableSystem", fetch = FetchType.EAGER)
    private List<CableSystemNode> cableSystemNodes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cableSystem", fetch = FetchType.EAGER)
    @OrderBy("code asc")
    private List<Segment> segments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cableSystem", fetch = FetchType.EAGER)
    private List<Path> paths;

    public boolean isNull() {
        return ((id == 0L) && (name == null));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof CableSystem)) {
            return false;
        }

        CableSystem other = (CableSystem) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public String toString() {
        return getCode();
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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the commercialModel
     */
    public CommercialModel getCommercialModel() {
        return commercialModel;
    }

    /**
     * @param commercialModel the commercialModel to set
     */
    public void setCommercialModel(CommercialModel commercialModel) {
        this.commercialModel = commercialModel;
    }

    /**
     * @return the transmissionPath
     */
    public TransmissionPath getTransmissionPath() {
        return transmissionPath;
    }

    /**
     * @param transmissionPath the transmissionPath to set
     */
    public void setTransmissionPath(TransmissionPath transmissionPath) {
        this.transmissionPath = transmissionPath;
    }

    /**
     * @return the operator
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(Operator oper) {
        operator = oper;
        if (operator != null && operator.isNull()) {
            operator = null;
        }
    }

    /**
     * @return the region
     */
    public CableSystemRegion getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(CableSystemRegion region) {
        this.region = region;
    }

    /**
     * @return the status
     */
    public CableSystemStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(CableSystemStatus status) {
        this.status = status;
    }

    /**
     * @return the minimumInvestmentUnit
     */
    public MinimumInvestmentUnit getMinimumInvestmentUnit() {
        return minimumInvestmentUnit;
    }

    /**
     * @param minimumInvestmentUnit the minimumInvestmentUnit to set
     */
    public void setMinimumInvestmentUnit(MinimumInvestmentUnit miu) {
        minimumInvestmentUnit = (miu != null && miu.isNull()) ? null : miu;
    }

    /**
     * @return the activationUnit
     */
    public ActivationUnit getActivationUnit() {
        return activationUnit;
    }

    /**
     * @param activationUnit the activationUnit to set
     */
    public void setActivationUnit(ActivationUnit activationUnit) {
        this.activationUnit = activationUnit;
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
     * @return the url
     */
    public String getUrl() {
        return (url == null) ? "" : url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the terminatingCountries
     */
    public String getTerminatingCountries() {
        return terminatingCountries;
    }

    /**
     * @param terminatingCountries the terminatingCountries to set
     */
    public void setTerminatingCountries(String terminatingCountries) {
        this.terminatingCountries = terminatingCountries;
    }

    /**
     * @return the inServiceDate
     */
    public Date getInServiceDate() {
        return inServiceDate;
    }

    /**
     * @param inServiceDate the inServiceDate to set
     */
    public void setInServiceDate(Date inServiceDate) {
        this.inServiceDate = inServiceDate;
    }

    /**
     * @return the retirementDate
     */
    public Date getRetirementDate() {
        return retirementDate;
    }

    /**
     * @param retirementDate the retirementDate to set
     */
    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    /**
     * @return the cableSystemNodes
     */
    public List<CableSystemNode> getCableSystemNodes() {
        return cableSystemNodes;
    }

    /**
     * @param cableSystemNodes the cableSystemNodes to set
     */
    public void setCableSystemNodes(List<CableSystemNode> cableSystemNodes) {
        this.cableSystemNodes = cableSystemNodes;
    }

    /**
     * @return the segments
     */
    public List<Segment> getSegments() {
        return segments == null ? new ArrayList<Segment>() : segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    /**
     * @return the paths
     */
    public List<Path> getPaths() {
        return (paths == null) ? new ArrayList<Path>() : paths;
    }

    /**
     * @param paths the paths to set
     */
    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
