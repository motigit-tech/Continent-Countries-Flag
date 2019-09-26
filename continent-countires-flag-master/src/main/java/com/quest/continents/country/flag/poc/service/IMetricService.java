/**
 * 
 */
package com.quest.continents.country.flag.poc.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Moti
 *
 */
public interface IMetricService {

	
	public void increaseCount(final String request, final int status);

    public ConcurrentMap<String, ConcurrentHashMap<Integer, Integer>> getFullMetric();
    

}
