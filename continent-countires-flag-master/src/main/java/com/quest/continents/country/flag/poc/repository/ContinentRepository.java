/**
 * @author Moti
 */
package com.quest.continents.country.flag.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.quest.continents.country.flag.poc.document.ContinentDocument;


/**
 * The Interface ContinentRepository.
 */
public interface ContinentRepository extends MongoRepository<ContinentDocument, String> {
	
	/**
	 * Find by continent name.
	 *
	 * @param continent the continent
	 * @return the list
	 */
	@Query("{continent: { $regex: ?0,  $options: 'i' } })")
	List<ContinentDocument> findByContinentName(String continent);

}
