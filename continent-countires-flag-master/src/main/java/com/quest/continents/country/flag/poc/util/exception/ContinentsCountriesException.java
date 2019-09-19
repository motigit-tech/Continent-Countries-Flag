package com.quest.continents.country.flag.poc.util.exception;


public class ContinentsCountriesException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ContinentsCountriesException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ContinentsCountriesException() {
		super();
	}
}