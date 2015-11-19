/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
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
@Table(name = "fabandwidth")
public class Bandwidth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name = "";
    @Column(name = "bandwidthorder")
    private long sortOrder;
    @Column(name = "kbpsvalue")
    private long kbps;
    @ManyToOne
    @JoinColumn(name = "fabandwidth2sourcelkp")
    private BandwidthSource source;

    public boolean isNull() {
        return ((getId() == 0L) && (getName().length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Bandwidth)) {
            return false;
        }

        Bandwidth other = (Bandwidth) o;
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

    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the sortOrder
     */
    public long getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(long sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return the kbps
     */
    public long getKbps() {
        return kbps;
    }

    /**
     * @param kbps the kbps to set
     */
    public void setKbps(long kbps) {
        this.kbps = kbps;
    }

    /**
     * @return the source
     */
    public BandwidthSource getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(BandwidthSource source) {
        this.source = source;
    }
}
