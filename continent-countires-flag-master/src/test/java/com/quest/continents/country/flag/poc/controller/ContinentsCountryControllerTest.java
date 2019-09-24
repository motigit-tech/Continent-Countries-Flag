package com.quest.continents.country.flag.poc.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.quest.continents.country.flag.poc.ContinentsCountryFlagPocApplication;
import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.model.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContinentsCountryFlagPocApplication.class)
@SpringBootTest
public class ContinentsCountryControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Autowired
	ContinentsCountryController continentsCountryController;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Ignore@Test
	public void testGetContinentCountriesFlag() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();

			MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/");
				this.mockMvc.perform(builder)
					.andExpect(ok);
	}
	
	@Ignore@Test
	public void testGetCountryFlag() throws Exception {
		final String uri = "http://localhost:8102/api/";
	     
		
		SearchCriteria searchCriteria = new SearchCriteria("continent", "Africa");
	    RestTemplate restTemplate = new RestTemplate();
	    ContinentDocument result = restTemplate.postForObject( uri, searchCriteria, ContinentDocument.class);
	 
	    System.out.println(result);
	}	

}