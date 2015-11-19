/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "adpath")
public class Path extends Audit implements Comparable<Path> {

    private static long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "path_seq", sequenceName = "adpath_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "path_seq")
    private long id;
    private String code = "";
    @Column(name = "miu_km")
    private long miuKm;
    @ManyToOne
    @JoinColumn(name = "cableSystemId")
    private CableSystem cableSystem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "path", fetch = FetchType.EAGER)
    private List<PathSegment> segments;

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
        if (!(o instanceof Path)) {
            return false;
        }

        Path other = (Path) o;
        return this.id == other.id;
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
        if (segments == null || segments.isEmpty()) {
            return new CableSystemNode();
        }
        return segments.get(0).getNodeA();
    }

    /**
     * @return the nodeB
     */
    public CableSystemNode getNodeB() {
        if (segments == null || segments.isEmpty()) {
            return new CableSystemNode();
        }
        return segments.get(segments.size() - 1).getNodeB();
    }

    /**
     * @return the length
     */
    public long getLength() {
        if (segments == null) {
            return 0;
        }
        long length = 0L;
        for (PathSegment segment : segments) {
            length = length + segment.getLength();
        }
        return length;
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
     * @return the segments
     */
    public List<PathSegment> getSegments() {
        return (segments == null) ? new ArrayList<PathSegment>() : segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(List<PathSegment> segments) {

        // if we currently have a list of segments check whether merge details in rather than replace
        if (this.segments == null) {
            this.segments = segments;
        } else if (segments == null) {
            this.segments = null;
        } else {
            // we have values in new segments and current segments so merge Path Segment id
            // from current segment if new segment has same segment id and index.
            // Otherwise database will think we are creating a new Path segment.
            for (int i = 0; i < this.segments.size(); i++) {
                PathSegment current = this.segments.get(i);
                PathSegment newSeg;
                try {
                    newSeg = segments.get(i);
                    // if newSeg is the same as current then copy id across
                    if ((newSeg.getSegment().getId() == current.getSegment().getId())
                            && newSeg.getSeqNo() == current.getSeqNo()) {
                        newSeg.setId(current.getId());
                    }
                } catch (IndexOutOfBoundsException ex) {
                    break;
                }
            }
            this.segments = segments;
        }
    }

    /**
     * @return the miuKm
     */
    public long getMiuKm() {
        return miuKm;
    }

    /**
     * @param miuKm the miuKm to set
     */
    public void setMiuKm(long miuKm) {
        this.miuKm = miuKm;
    }

    @Override
    public int compareTo(Path that) {
        return this.code.compareTo(that.code);
    }
}
