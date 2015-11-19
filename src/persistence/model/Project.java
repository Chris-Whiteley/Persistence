/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity
@Table(name = "adcapexprojcode")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "capexprojcode")
    private String code;
    @Column(name = "project")
    private String name = "";
    private String deprecated;

    public boolean isNull() {
        return ((id == 0L) && (name.length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Project)) {
            return false;
        }

        Project other = (Project) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
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
     * @return the deprecated
     */
    public String getDeprecated() {
        return deprecated;
    }

    /**
     * @param deprecated the deprecated to set
     */
    public void setDeprecated(String deprecated) {
        this.deprecated = deprecated;
    }

    @Override
    public String toString() {
        // note name is non-mandatory so can be null
        return (name == null || name.length() == 0) ? "" : code + " - " + name;
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
}
