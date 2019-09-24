/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.controller;
/*

 */

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.document.CountryDocument;
import com.quest.continents.country.flag.poc.model.SearchCriteria;
import com.quest.continents.country.flag.poc.service.impl.ContinentCountriesFlagService;
import com.quest.continents.country.flag.poc.util.annotation.AuditAndMeter;
import com.quest.continents.country.flag.poc.util.annotation.AuditAndMeterInterceptor;

import lombok.extern.slf4j.Slf4j;
/*
 *  This controller is going to provide to returns continent's country flag and count
 */
@RestController
@Slf4j
@AuditAndMeter(value = {AuditAndMeterInterceptor.class})
public class ContinentsCountryController {
	
	//private static final Logger log =  LoggerFactory.getLogger(ContinentsCountryController.class);
    
	@Autowired
	ContinentCountriesFlagService continentCountriesFlagService;
		
    /*
     * getAllContinentFlag: It's rest api service which has providing all continent's country.
     * @Return Json response
     */
	 @GetMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getAllContinentFlag() {
		return new ResponseEntity<List<ContinentDocument>>(continentCountriesFlagService.findAllContinent(), HttpStatus.OK);
	}
		
     /*
      * getContinentCountriesFlag: It's generic rest api service which has providing continent's country
      *  and specific country flag.
      *  @RequestBody SearchCriteria
      *  @Return Json response
      */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getContinentCountriesFlag(@Valid @RequestBody SearchCriteria searchCriteria) {
		
		//log.info("ContinentsCountryController::getContinentCountriesFlag: start");
		
		/* Validating Request body */
		Optional<SearchCriteria> checkSearchCriteriaNull = Optional.ofNullable(searchCriteria);
		if (!checkSearchCriteriaNull.isPresent() || null == checkSearchCriteriaNull.get().getFieldName()) {
			
			return new ResponseEntity<List<ContinentDocument>>(continentCountriesFlagService.findAllContinent(), HttpStatus.OK);

		} 
		
		/* if search is based on continent */
		else if (checkSearchCriteriaNull.get().getFieldName().equals("continent")) {

			return new ResponseEntity<List<ContinentDocument>>(
					continentCountriesFlagService.findByContientName(checkSearchCriteriaNull.get().getFieldValue()),
					HttpStatus.OK);

		} 
		
		/* if search is based on country */
		else if (checkSearchCriteriaNull.get().getFieldName().equals("country")) {

			return new ResponseEntity<CountryDocument>(
					(CountryDocument) continentCountriesFlagService.findByCountryName(checkSearchCriteriaNull.get().getFieldValue()),
					HttpStatus.OK);

		} else {
			
			/* if searched criteria not match */
			return new ResponseEntity<String>("Not Found", HttpStatus.OK);
		}

	}

}