/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.document.CountryDocument;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("continentCountriesFlagService")
public class ContinentCountriesFlagServiceImpl implements ContinentCountriesFlagService {
	
	/* Autowired continent repository */
	@Autowired
	ContinentRepository continentRepository;
	
	/* Autowired country repository */
	@Autowired
	CountryRepository countryFlagRepository;	

	/* It returns continent to provide continent
	 * @Param continent
	 * @Return List<ContinentDocument> List of continent
	 */
	@Override
	public List<ContinentDocument> findByContientName(String continent) {
		
		return continentRepository.findByContinentName(continent);
				
	}
    
	/* It returns Country to provide country name
	 * @Param countryName
	 * @Return List<CountryDocument> List of countries
	 */
	@Override
	public List<CountryDocument> findByCountryName(String countryName) {
		
		return countryFlagRepository.findByCountryName(countryName);
		
		
	}
	
	/* It returns all continents 
	 * @Return List<ContinentDocument> List of continent
	 */
	@Override
	public List<ContinentDocument> findAllContinent() {
		 return continentRepository.findAll();
	}
   
	/* It returns all continents 
	 * @Return List<ContinentDocument> List of continent
	 */

	@Override
	public List<CountryDocument> findAllCountries() {
		 return countryFlagRepository.findAll();
	}

	

}
