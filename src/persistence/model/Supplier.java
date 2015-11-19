/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name = "";
    private String country;
    private String deprecated;

    public boolean isNull() {
        return ((id == 0L) && (name.length() == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Supplier)) {
            return false;
        }

        Supplier other = (Supplier) o;
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
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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
        return (name.length() == 0) ? "" : country + " / " + name;
    }
}
