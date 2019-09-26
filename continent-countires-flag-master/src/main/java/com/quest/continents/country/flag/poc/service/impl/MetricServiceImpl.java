/**
 * 
 */
package com.quest.continents.country.flag.poc.service.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.quest.continents.country.flag.poc.service.IMetricService;

@Service
public class MetricServiceImpl implements IMetricService {

    private ConcurrentMap<String, ConcurrentHashMap<Integer, Integer>> metricMap;  
    
    
    /** Contrutor **/
    public MetricServiceImpl() {
        super();
        metricMap = new ConcurrentHashMap<String, ConcurrentHashMap<Integer, Integer>>();         
    }

    
    /** Method to increase count **/

    @Override
    public void increaseCount(final String request, final int status) {
        increaseMainMetric(request, status);         
    }

        
    private void increaseMainMetric(final String request, final int status) {
        ConcurrentHashMap<Integer, Integer> statusMap = metricMap.get(request);
        if (statusMap == null) {
            statusMap = new ConcurrentHashMap<Integer, Integer>();
        }

        Integer count = statusMap.get(status);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        statusMap.put(status, count);
        metricMap.put(request, statusMap);
    }   

    
	@Override
	public ConcurrentMap<String, ConcurrentHashMap<Integer, Integer>> getFullMetric() {
		
		return metricMap;
	}

}