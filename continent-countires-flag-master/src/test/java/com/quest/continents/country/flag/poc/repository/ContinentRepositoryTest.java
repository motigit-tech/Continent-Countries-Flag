package com.quest.continents.country.flag.poc.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
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
public class ContinentRepositoryTest {

    @Autowired private ContinentRepository continentRepo;
    
    @Before
    public void reset() {
       // TestData.continents();
    }
    
       
    @Ignore @Test
    public void testExists() {   
        assertEquals(1, continentRepo.findByContinentName("America").getCountries().length);
     }

   
}
