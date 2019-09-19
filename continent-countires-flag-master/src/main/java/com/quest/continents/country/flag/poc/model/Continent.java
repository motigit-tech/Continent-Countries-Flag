package com.quest.continents.country.flag.poc.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "content")
public class Continent
{
    private String continent;
	private Countries[] countries;
	

    public Continent(String continent, Countries[] countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}


    public String getContinent ()
    {
        return continent;
    }

    public void setContinent (String continent)
    {
        this.continent = continent;
    }

    public Countries[] getCountries ()
    {
        return countries;
    }

    public void setCountries (Countries[] countries)
    {
        this.countries = countries;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [continent = "+continent+", countries = "+countries+"]";
    }
}