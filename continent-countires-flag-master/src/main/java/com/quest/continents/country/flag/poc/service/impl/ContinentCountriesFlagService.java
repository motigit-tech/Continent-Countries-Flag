/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.service.impl;

import java.util.List;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.document.CountryDocument;

/* ContinentCountriesFlagService interface to serve continent and country based search*/
public interface ContinentCountriesFlagService {
	

	public List<ContinentDocument> findAllContinent();
	
	public List<CountryDocument> findAllCountries();
	
	/* To returns all countries to provide continent name */
	public List<ContinentDocument> findByContientName(String contient);
	
	/* To returns all countries to provide continent name */
	public List<CountryDocument> findByCountryName(String country);
	

}
