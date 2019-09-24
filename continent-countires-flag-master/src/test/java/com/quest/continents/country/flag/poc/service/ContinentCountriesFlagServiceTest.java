package com.quest.continents.country.flag.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.document.CountryDocument;
import com.quest.continents.country.flag.poc.model.Countries;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.repository.CountryRepository;
import com.quest.continents.country.flag.poc.service.impl.ContinentCountriesFlagServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContinentCountriesFlagServiceTest {
	
	@Mock
	private ContinentRepository continentRepository;
	
	@Mock
	private CountryRepository countryRepository;
	
	
	@InjectMocks
	private ContinentCountriesFlagServiceImpl continentCountriesFlagService; 
		
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
	}
	@Test
	public void testFindAllContinents(){
		
		List <ContinentDocument> continentList = new ArrayList<ContinentDocument>();
		List <Countries>CountriesAfricaList = new ArrayList<Countries>();	
		List <Countries>CountriesAmericaList = new ArrayList<Countries>();
		
		CountriesAfricaList.add(new Countries("Nigeria", "🇳🇬"));
		CountriesAfricaList.add(new Countries("Ethiopia", "🇪🇹"));
		CountriesAfricaList.add(new Countries("Egypt", "🇪🇬"));
		CountriesAfricaList.add(new Countries("DR Congo", "🇨🇩"));
		CountriesAfricaList.add(new Countries("South Africa", "🇿🇦"));		
		
		CountriesAmericaList.add(new Countries("USA", "🇺🇸"));
		CountriesAmericaList.add(new Countries("Brazil", "🇧🇷"));
		
		ContinentDocument continentAfrica = new ContinentDocument("1", "Africa");
		ContinentDocument continentAmerica = new ContinentDocument("2", "America");
		
		continentList.add(continentAfrica);
		continentList.add(continentAmerica);

		when(continentRepository.findAll()).thenReturn(continentList);
		
		List<ContinentDocument> result = continentCountriesFlagService.findAllContinent();
		
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetContinentByName(){
		List <ContinentDocument> continentList = new ArrayList<ContinentDocument>();		
		ContinentDocument continentAmerica = new ContinentDocument("2", "America");			
		continentList.add(continentAmerica);
		
		when(continentRepository.findByContinentName("America")).thenReturn(continentList);
		List<ContinentDocument> result = continentCountriesFlagService.findByContientName("America");
		assertEquals(1, result.size());
	}	
 
	@Test
	public void testFindAllCountires(){
		
		List <ContinentDocument> continentList = new ArrayList<ContinentDocument>();
		List <CountryDocument>CountriesAfricaList = new ArrayList<CountryDocument>();	
			
		ContinentDocument continentAfrica = new ContinentDocument("1", "Africa");	
		
		CountriesAfricaList.add(new CountryDocument("NI","Nigeria", "🇳🇬", continentAfrica.getContinentId()));
		CountriesAfricaList.add(new CountryDocument("NG","Ethiopia", "🇪🇹", continentAfrica.getContinentId()));
		CountriesAfricaList.add(new CountryDocument("EG","Egypt", "🇪🇬", continentAfrica.getContinentId()));
		CountriesAfricaList.add(new CountryDocument("DR","DR Congo", "🇨🇩", continentAfrica.getContinentId()));
		CountriesAfricaList.add(new CountryDocument("SA","South Africa", "🇿🇦", continentAfrica.getContinentId()));
					
		continentList.add(continentAfrica);
		
		when(countryRepository.findAll()).thenReturn(CountriesAfricaList);
		
		List<CountryDocument> result = continentCountriesFlagService.findAllCountries();
		assertEquals(5, result.size());
	}

}
