package com.quest.continents.country.flag.poc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;

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
	    CommandLineRunner init(ContinentRepository continentRepository) {

	        return args -> {

	        	 List <Continent>list =  continentRepository.findAll();
	            
	            list.forEach((c) -> {
	            	System.out.println(c.getContinent());
	            	});                    

	        };
	 	}
	        @Bean
	        public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
	                                           MongoMappingContext context) {

	            MappingMongoConverter converter =
	                    new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
	            converter.setTypeMapper(new DefaultMongoTypeMapper(null));

	            MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

	            return mongoTemplate;

	        }     

}
