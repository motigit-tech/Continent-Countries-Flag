package com.quest.continents.country.flag.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Countries;



@Repository("continentRepository")
public interface ContinentRepository extends MongoRepository<Continent, String> {
	
	@Query(value = "{ 'continent' : ?0}")
	Continent findByContinentName(final String continent);

	@Query("{'countries.name': ?0}")
	Countries findByCountry(final String country);

	
}
