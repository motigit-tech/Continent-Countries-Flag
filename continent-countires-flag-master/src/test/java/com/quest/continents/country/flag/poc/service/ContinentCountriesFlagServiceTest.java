package com.quest.continents.country.flag.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Countries;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.service.impl.ContinentCountriesFlagServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContinentCountriesFlagServiceTest {
	
	@Mock
	private ContinentRepository continentRepository;
	
	
	@InjectMocks
	private ContinentCountriesFlagServiceImpl continentCountriesFlagService; 
		
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
	}
	
	@Ignore@Test
	public void testFindAllContinents(){
		List <Continent>continentList = new ArrayList<Continent>();		
		List <Countries>CountriesAfricaList = new ArrayList<Countries>();	
		List <Countries>CountriesAmericaList = new ArrayList<Countries>();
		
		CountriesAfricaList.add(new Countries("Nigeria", "🇳🇬"));
		CountriesAfricaList.add(new Countries("Ethiopia", "🇪🇹"));
		CountriesAfricaList.add(new Countries("Egypt", "🇪🇬"));
		CountriesAfricaList.add(new Countries("DR Congo", "🇨🇩"));
		CountriesAfricaList.add(new Countries("South Africa", "🇿🇦"));		
		
		CountriesAmericaList.add(new Countries("USA", "🇺🇸"));
		CountriesAmericaList.add(new Countries("Brazil", "🇧🇷"));
		
		Continent continentAfrica = new Continent("Africa", (Countries[]) CountriesAfricaList.toArray());
		Continent continentAmerica = new Continent("America", (Countries[]) CountriesAmericaList.toArray());
		
		continentList.add(continentAfrica);
		continentList.add(continentAmerica);

		when(continentRepository.findAll()).thenReturn(continentList);
		
		List<Continent> result = continentCountriesFlagService.findAll();
		assertEquals(2, result.size());
	}
	
	@Ignore@Test
	public void testGetContinentById(){
		List <Continent>continentList = new ArrayList<Continent>();		
		List <Countries>CountriesAfricaList = new ArrayList<Countries>();	
		List <Countries>CountriesAmericaList = new ArrayList<Countries>();
		
		CountriesAfricaList.add(new Countries("Nigeria", "🇳🇬"));
		CountriesAfricaList.add(new Countries("Ethiopia", "🇪🇹"));
		CountriesAfricaList.add(new Countries("Egypt", "🇪🇬"));
		CountriesAfricaList.add(new Countries("DR Congo", "🇨🇩"));
		CountriesAfricaList.add(new Countries("South Africa", "🇿🇦"));		
		
		CountriesAmericaList.add(new Countries("USA", "🇺🇸"));
		CountriesAmericaList.add(new Countries("Brazil", "🇧🇷"));
		
		Continent continentAfrica = new Continent("Africa", (Countries[]) CountriesAfricaList.toArray());
		Continent continentAmerica = new Continent("America", (Countries[]) CountriesAmericaList.toArray());
		
		continentList.add(continentAfrica);
		continentList.add(continentAmerica);
		
		when(continentRepository.findByContinentName("America")).thenReturn(continentAmerica);
		List<Countries> result = continentCountriesFlagService.findByContientId("America");
		assertEquals(2, result.size());
	}	

}
