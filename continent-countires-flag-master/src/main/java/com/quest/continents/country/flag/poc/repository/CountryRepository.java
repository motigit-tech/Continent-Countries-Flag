/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quest.continents.country.flag.poc.document.CountryDocument;



/**
 * The Interface CountryRepository.
 */
public interface CountryRepository extends MongoRepository<CountryDocument, String>{

	/**
	 * Find by continent id.
	 *
	 * @param continentId the continent id
	 * @return the list
	 */
	List<CountryDocument> findByContinentId(String continentId);
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the country document
	 */
	CountryDocument findByName(String name);
	
	/**
	 * Search name.
	 *
	 * @param name the country
	 * @return the list
	 */
	@Query("{name: { $regex: ?0,  $options: 'i' } })")
	List<CountryDocument> findByCountryName(String name);
}
