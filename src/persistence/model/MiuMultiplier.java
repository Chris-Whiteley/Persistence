/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "miu_multiplier_v")
public class MiuMultiplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "miu_lkp")
    private MinimumInvestmentUnit minimumInvestmentUnit;
    private long cableSystemId;
    @Column(name = "bandwidth_id")
    private long bandwidthId;
    @Column(name = "no_of_mius")
    private BigDecimal noOfMius;
    @Column(name = "whole_joint")
    private String wholeOrJoint;
    @Column(name = "multiplication_factor")
    private BigDecimal multiplicationFactor;

    public boolean isNull() {
        return ((getId() == 0L) && (getCableSystemId() == 0L));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof MiuMultiplier)) {
            return false;
        }

        MiuMultiplier other = (MiuMultiplier) o;
        return this.getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
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
     * @return the minimumInvestmentUnit
     */
    public MinimumInvestmentUnit getMinimumInvestmentUnit() {
        return minimumInvestmentUnit;
    }

    /**
     * @param minimumInvestmentUnit the minimumInvestmentUnit to set
     */
    public void setMinimumInvestmentUnit(MinimumInvestmentUnit minimumInvestmentUnit) {
        this.minimumInvestmentUnit = minimumInvestmentUnit;
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
     * @return the bandwidthId
     */
    public long getBandwidthId() {
        return bandwidthId;
    }

    /**
     * @param bandwidthId the bandwidthId to set
     */
    public void setBandwidthId(long bandwidthId) {
        this.bandwidthId = bandwidthId;
    }

    /**
     * @return the noOfMius
     */
    public BigDecimal getNoOfMius() {
        return noOfMius;
    }

    /**
     * @param noOfMius the noOfMius to set
     */
    public void setNoOfMius(BigDecimal noOfMius) {
        this.noOfMius = noOfMius;
    }

    /**
     * @return the wholeOrJoint
     */
    public String getWholeOrJoint() {
        return wholeOrJoint;
    }

    /**
     * @param wholeOrJoint the wholeOrJoint to set
     */
    public void setWholeOrJoint(String wholeOrJoint) {
        this.wholeOrJoint = wholeOrJoint;
    }

    /**
     * @return the multiplicationFactor
     */
    public BigDecimal getMultiplicationFactor() {
        return multiplicationFactor;
    }

    /**
     * @param multiplicationFactor the multiplicationFactor to set
     */
    public void setMultiplicationFactor(BigDecimal multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }
}
