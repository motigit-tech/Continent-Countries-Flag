/**
 * @author Moti
 */

package com.quest.continents.country.flag.poc.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class CountryDocument.
 */
@Document(collection = "countries")
public class CountryDocument {

	/** The country id. */
	@Id
	private String countryId;
	
	/** The name. */
	private String name;

	/** The flag. */
	private String flag;

	/** The continent id. */
	private String continentId;
	
	public CountryDocument(String countryId, String name, String flag, String continentId) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.flag = flag;
		this.continentId = continentId;
	}


	/**
	 * Gets the country id.
	 *
	 * @return the country id
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId the new country id
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the new flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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

}
