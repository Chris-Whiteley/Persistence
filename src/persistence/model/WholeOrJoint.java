/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "falookup")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "falookup2fadomain", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(DomainValue.Domains.ADLEDGERCIRCUITOWNERTYPE)
public class WholeOrJoint extends DomainValue {

    private static final long serialVersionUID = 1L;

    public boolean isWhole() {
        return getNonNullName().equalsIgnoreCase("Whole");
    }

    public boolean isJoint() {
        return getNonNullName().equalsIgnoreCase("Half");
    }

    private String getNonNullName() {
        String name = getName();
        return (name == null) ? "" : name;
    }
}
