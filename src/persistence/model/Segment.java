/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "adsegment")
public class Segment extends Audit {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "segment_seq", sequenceName = "adsegment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "segment_seq")
    private long id;
    private String code = "";
    @Column(name = "comment_text")
    private String comment = "";
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cablesystemid", referencedColumnName = "cablesystemid", insertable = false, updatable = false),
        @JoinColumn(name = "nodea_id", referencedColumnName = "nodeid")
    })
    private CableSystemNode nodeA;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cablesystemid", referencedColumnName = "cablesystemid", insertable = false, updatable = false),
        @JoinColumn(name = "nodeb_id", referencedColumnName = "nodeid")
    })
    private CableSystemNode nodeB;
    // length in KM
    @Column(name = "segment_length")
    private long length;
    @ManyToOne
//    @JoinColumn(name = "cableSystemId", updatable = false, insertable = false)
    @JoinColumn(name = "cableSystemId")
    private CableSystem cableSystem;

    public boolean isNull() {
        return ((id == 0L) && (code.length() == 0));
    }

    public boolean isNew() {
        return (id == 0L);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Segment)) {
            return false;
        }

        Segment other = (Segment) o;

        if (this.nodeA != null && this.nodeB != null) {
            return (this.nodeA.getNode().equals(other.nodeA.getNode()) & this.nodeB.getNode().equals(other.nodeB.getNode()))
                    || (this.nodeA.getNode().equals(other.nodeB.getNode()) & this.nodeB.getNode().equals(other.nodeA.getNode()));
        } else {
            return this.id == other.id;
        }
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
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
     * @return the code
     */
    public String getCode() {
        return (code == null) ? "" : code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the nodeA
     */
    public CableSystemNode getNodeA() {
        return (nodeA == null) ? new CableSystemNode() : nodeA;
    }

    /**
     * @param nodeA the nodeA to set
     */
    public void setNodeA(CableSystemNode nodeA) {
        this.nodeA = nodeA;
    }

    /**
     * @return the nodeB
     */
    public CableSystemNode getNodeB() {
        return (nodeB == null) ? new CableSystemNode() : nodeB;
    }

    /**
     * @param nodeB the nodeB to set
     */
    public void setNodeB(CableSystemNode nodeB) {
        this.nodeB = nodeB;
    }

    /**
     * @return the length
     */
    public long getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(long length) {
        this.length = length;
    }

    /**
     * @return the cableSystem
     */
    public CableSystem getCableSystem() {
        return cableSystem;
    }

    /**
     * @param cableSystem the cableSystem to set
     */
    public void setCableSystem(CableSystem cableSystem) {
        this.cableSystem = cableSystem;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment == null ? "" : comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
