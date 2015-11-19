/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
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
@Entity
@Table(name = "adnode")
public class Node implements Serializable, Comparable<Node> {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "node_seq", sequenceName = "adnode_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "node_seq")
    private long id;
    private String code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "node_type_lkp")
    private NodeType nodeType;
    @ManyToOne
    @JoinColumn(name = "adnode2city")
    private City city;

    /**
     * @return the name
     */
    public String getName() {
        return (name == null) ? "" : name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
//        return name + "|" + country.getName() + "|" + sites;
        return getName();
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
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the nodeType
     */
    public NodeType getNodeType() {
        return nodeType;
    }

    /**
     * @param nodeType the nodeType to set
     */
    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Node)) {
            return false;
        }

        Node other = (Node) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public int compareTo(Node that) {
        return this.name.compareTo(that.name);
    }
}
