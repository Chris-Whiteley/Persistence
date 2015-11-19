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
@Table(name = "adcurrency")
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Currency gbp;
    @Id
    private long id;
    private String code;
    private String name = "";
    private String deprecated;

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
        return (code == null) ? "" : code + "(" + name + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Currency)) {
            return false;
        }

        Currency other = (Currency) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    public boolean isNull() {
        return ((getId() == 0L) && (getName().length() == 0));
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    public static Currency GBP() {
        if (gbp == null) {
            gbp = new Currency();
            gbp.setId(194);
            gbp.setCode("GBP");
            gbp.setName("British Pounds");
            gbp.setDeprecated("N");
        }
        return gbp;
    }
}
