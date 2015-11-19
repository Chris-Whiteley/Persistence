/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author Chris Whiteley
 */
@Entity()
@Table(name = "falookup")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "falookup2fadomain", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(DomainValue.Domains.CABLESYSTEMS_ACCESS_COUNTRIES)
public class Country extends DomainValue {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    @OrderBy("name ASC")
    private Collection<City> cities;

    /**
     * @return the cities
     */
    public Collection<City> getCities() {
        return (cities == null) ? new ArrayList<City>() : cities;
    }

    public Collection<City> getCitiesWithSites() {
        Collection<City> allCities = getCities();
        Collection<City> citiesWithSites = new ArrayList<City>();
        for (City city : allCities) {
            if (!city.getSites().isEmpty()) {
                citiesWithSites.add(city);
            }
        }
        return citiesWithSites;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }
}
