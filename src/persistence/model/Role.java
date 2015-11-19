/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import persistence.model.DomainValue.Domains;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "falookup")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "falookup2fadomain", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(Domains.FPJOBROLE)
public class Role extends DomainValue {

    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<User> users;

    /**
     * @return the users
     */
    public Collection<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
