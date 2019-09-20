/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.model;

import java.io.Serializable;
import java.util.List;


public class Continent implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1182745813564234412L;
	
	/** The continent. */
	private String continent;
	
	/** The countries. */
	private List<Countries> countries;
	

    public Continent(String continent, List<Countries> countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}

    /**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
    public String getContinent ()
    {
        return continent;
    }

    public void setContinent (String continent)
    {
        this.continent = continent;
    }
    
    /**
	 * Gets the countries.
	 *
	 * @return the countries
	 */
    public List<Countries> getCountries ()
    {
        return countries;
    }

    public void setCountries (List<Countries> countries)
    {
        this.countries = countries;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString()
    {
        return "ClassPojo [continent = "+continent+", countries = "+countries+"]";
    }
}