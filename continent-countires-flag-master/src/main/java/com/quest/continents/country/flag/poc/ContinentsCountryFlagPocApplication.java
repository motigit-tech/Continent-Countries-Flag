/**
 * 
 */
package com.quest.continents.country.flag.poc;

/**
 * @author Moti
 *
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ContinentsCountryFlagPocApplication {

	private static final Logger log =  LoggerFactory.getLogger(ContinentsCountryFlagPocApplication.class);
	
	public static void main(String[] args) {
		
		log.debug("Continent context loading...");
		SpringApplication.run(ContinentsCountryFlagPocApplication.class, args);
		log.debug("Continent context loaded...");
	}
	
	 	@Bean
	    CommandLineRunner init(ContinentRepository continentRepository, CountryRepository countryRepository) {
	 			 			 		
	 		/* ContinentDocument cd1 = new ContinentDocument();	 		
	 		cd1.setContinent("Oceania");
	 		
	 		continentRepository.save(cd1); 
	 		
	 		
	 		 ContinentDocument cd = continentRepository.findByContinentName("Oceania").get(0);
	 		 String []country = new String[] {"Australia", "Papua New Guinea", "New Zealand","Fiji","Solomon Islands"};
	 		 String []flag = new String [] {"🇦🇺", "🇵🇬","🇳🇿","🇫🇯","🇸🇧"};
	 		 
	 		 for(int i =0; i<country.length; i++) {
		 		CountryDocument countryDocument = new CountryDocument();
		 		countryDocument.setContinentId(cd.getContinentId());
		 		countryDocument.setName(country[i]);
		 		countryDocument.setFlag(flag[i]);
		 		countryRepository.save(countryDocument);
	 		 } */
	 		System.out.println("Result: "+continentRepository.findByContinentName("Oceania").toString());

	        return args -> {

	        	 List<ContinentDocument>list =  continentRepository.findAll();
	            
	            list.forEach((c) -> {
	            	    //System.out.println(c.getContinent());
	            	    countryRepository.findByContinentId(c.getContinentId()).forEach((cn)-> {System.out.println("Country Name: "+ cn.getName() +" Flag: "+ cn.getFlag());});
	            	});                    

	        };
	        
	        
	        
	        
	 	}
	             

}

