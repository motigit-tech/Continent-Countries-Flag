package com.quest.continents.country.flag.poc.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quest.continents.country.flag.poc.ContinentsCountryFlagPocApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContinentsCountryFlagPocApplication.class)
@SpringBootTest
public class CountryRepositoryTest {

    @Autowired private CountryRepository countryRepository;
    
    @Before
    public void reset() {
       // TestData.continents();
    }
    
       
   @Test
    public void testExists() {   
         assertNotNull(countryRepository.findByCountryName("India"));
     }

   @Test
   public void testCountryAll() {
	   assertEquals(25, countryRepository.findAll().size());
   }
   
   @Test
   public void testContentNotExist() {
	   assertEquals(0, countryRepository.findByCountryName("ABC").size());
   }
   
}
