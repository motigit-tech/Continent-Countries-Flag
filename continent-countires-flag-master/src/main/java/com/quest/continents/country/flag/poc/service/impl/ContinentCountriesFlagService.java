package com.quest.continents.country.flag.poc.service.impl;

import java.util.List;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Countries;

public interface ContinentCountriesFlagService {
	
	public List<Countries> findByContientId(String contient);
	public Countries findByCountryId(String country);
	public List<Continent> findAll();

}
