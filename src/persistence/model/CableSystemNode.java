/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

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
@IdClass(CableSystemNodePk.class)
@Entity
@Table(name = "adcablesystemnode")
public class CableSystemNode extends Audit {

    private static final long serialVersionUID = 1L;
    @Id
    private long cableSystemId;
    @Id
    private long nodeId;
    @Column(name = "comment_text")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "cableSystemId", updatable = false, insertable = false)
    private CableSystem cableSystem;
    @ManyToOne
    @JoinColumn(name = "nodeId", updatable = false, insertable = false)
    private Node node;

    public boolean isNull() {
        return (cableSystemId == 0L);
    }

    @Override
    public String toString() {
        return (node == null) ? "" : node.toString();
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
        if (!(obj instanceof CableSystemNode)) {
            return false;
        }
        CableSystemNode pk = (CableSystemNode) obj;
        return (pk.cableSystemId == cableSystemId) && (pk.nodeId == nodeId);
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
     * @return the nodeId
     */
    public long getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return (comment == null) ? "" : comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(Node node) {
        this.node = node;
    }
}
