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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "adpathsegment")
public class PathSegment extends Audit {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pathsegment_seq", sequenceName = "adpathsegment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pathsegment_seq")
    private long id;
    @Column(name = "seq_no")
    private int seqNo;
    @ManyToOne
//    @JoinColumn(name = "segment_id", referencedColumnName = "id", insertable=false, updatable=false)
    @JoinColumn(name = "path_id", referencedColumnName = "id", updatable = false)
    private Path path;
    @ManyToOne
//    @JoinColumn(name = "segment_id", referencedColumnName = "id", insertable=false, updatable=false)
    @JoinColumn(name = "segment_id", referencedColumnName = "id", updatable = false)
    private Segment segment;
    @ManyToOne
//    @JoinColumn(name = "startnode_id", referencedColumnName = "id", insertable=false, updatable=false)
    @JoinColumn(name = "startnode_id", referencedColumnName = "id")
    private Node startNode;

    public boolean isNull() {
        return ((id == 0L) && (getSeqNo() == 0));
    }

    public boolean isNew() {
        return (id == 0L);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PathSegment)) {
            return false;
        }
        PathSegment other = (PathSegment) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getId()).hashCode();
    }

    @Override
    public String toString() {
        if (isNull()) {
            return "";
        }
        if (getSegment().getNodeA().getNodeId() == getStartNode().getId()) {
            return getSeqNo() + " " + getSegment().getNodeA() + " " + getSegment().getNodeB();
        } else {
            return getSeqNo() + " " + getSegment().getNodeB() + " " + getSegment().getNodeA();
        }
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
     * @return the nodeA
     */
    public CableSystemNode getNodeA() {
        if (getSegment() == null || getStartNode() == null) {
            return null;
        }
        if (getSegment().getNodeA().getNodeId() == getStartNode().getId()) {
            return getSegment().getNodeA();
        } else {
            return getSegment().getNodeB();
        }
    }

    /**
     * @return the nodeB
     */
    public CableSystemNode getNodeB() {
        if (getSegment() == null || getStartNode() == null) {
            return null;
        }
        if (getSegment().getNodeA().getNodeId() == getStartNode().getId()) {
            return getSegment().getNodeB();
        } else {
            return getSegment().getNodeA();
        }
    }

    /**
     * @return the seqNo
     */
    public int getSeqNo() {
        return seqNo;
    }

    /**
     * @param seqNo the seqNo to set
     */
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
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
     * @return the segment
     */
    public Segment getSegment() {
        return segment;
    }

    /**
     * @param segment the segment to set
     */
    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    /**
     * @return the startNode
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * Determine the end node based on the start node.
     *
     * @return the endNode
     */
    public Node getEndNode() {
        if (startNode == null || segment == null) {
            return null;
        }

        if (segment.getNodeA().getNode().equals(startNode)) {
            return segment.getNodeB().getNode();
        } else {
            return segment.getNodeA().getNode();
        }
    }

    /**
     * @param startNode the startNode to set
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public long getLength() {
        if (segment == null) {
            return 0;
        }
        return segment.getLength();
    }
}
