/**
 * @author Moti
 */

package com.quest.continents.country.flag.poc.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class ContinentDocument.
 */
@Document(collection = "continents")
public class ContinentDocument {

	/** The continent id. */
	@Id
	private String continentId;
	

	/** The continent. */
	private String continent;

	/** Constructor */
	public ContinentDocument(String continentId, String continent) {
		super();
		this.continentId = continentId;
		this.continent = continent;
	}
	
	/**
	 * Gets the continent id.
	 *
	 * @return the continent id
	 */
	public String getContinentId() {
		return continentId;
	}

	/**
	 * Sets the continent id.
	 *
	 * @param continentId the new continent id
	 */
	public void setContinentId(String continentId) {
		this.continentId = continentId;
	}

	/**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}

	/**
	 * Sets the continent.
	 *
	 * @param continent the new continent
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

}
