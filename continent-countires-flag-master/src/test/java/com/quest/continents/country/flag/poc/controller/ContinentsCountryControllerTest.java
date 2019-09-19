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
import com.quest.continents.country.flag.poc.model.Continent;
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
		final String uri = "http://localhost:8080/api/";
	     
		
		SearchCriteria searchCriteria = new SearchCriteria("continent", "Africa");
	    RestTemplate restTemplate = new RestTemplate();
	    Continent result = restTemplate.postForObject( uri, searchCriteria, Continent.class);
	 
	    System.out.println(result);
	}
	
	
	/* @Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.text").exists())
		.andExpect(jsonPath("$.completed").exists())
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.text").value("Build the artifacts"))
		.andExpect(jsonPath("$.completed").value(false))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidToDoArgument() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/f").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(400))
			.andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."))
			.andDo(print());
	}
	
	@Test
	public void verifyInvalidToDoId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("ToDo doesn´t exist"))
		.andDo(print());
	}
	
	@Test
	public void verifyNullToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("ToDo doesn´t exist"))
		.andDo(print());
	}
	
	@Test
	public void verifyDeleteToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/todo/4").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("ToDo has been deleted"))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidToDoIdToDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/todo/9").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("ToDo to delete doesn´t exist"))
		.andDo(print());
	}
	
	
	@Test
	public void verifyInvalidToDoUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/todo/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{ \"idd\": \"8\", \"text\" : \"New ToDo Sample\", \"completed\" : \"false\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("ToDo to update doesn´t exist"))
		.andDo(print());
	} */

}