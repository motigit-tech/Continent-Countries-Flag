package com.quest.continents.country.flag.poc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.quest.continents.country.flag.poc.dao.CountryFlagDao;
import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Countries;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CountryFlagDaoImpl implements CountryFlagDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Continent> findByContientId(String contient) {
		Query query = new Query();
		query.addCriteria(Criteria.where("continent").is(contient));
		return mongoTemplate.findAll(Continent.class);
		
	}

	@Override
	public Countries findByCountryId(String country) {
		Query query = new Query();
		query.addCriteria(Criteria.where("country").is(country));
		return mongoTemplate.findOne(query, Countries.class);
	}
	

}
