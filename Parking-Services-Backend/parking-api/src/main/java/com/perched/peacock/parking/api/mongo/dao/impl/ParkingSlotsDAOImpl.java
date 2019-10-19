package com.perched.peacock.parking.api.mongo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.mongo.dao.ParkingSlotsDAO;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;

/**
 * 
 * @author pnvamshi
 *
 */

@Repository
public class ParkingSlotsDAOImpl implements ParkingSlotsDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public ParkingSlots getParkingSlotsInfo(String parkingRegion) {
		Query query = new Query();
		query.addCriteria(Criteria.where("parkingRegion").is(parkingRegion));
		return mongoTemplate.findOne(query, ParkingSlots.class);
	}
	
	@Override
	public List<String> getParkingRegions() {
		return mongoTemplate.findDistinct("parkingRegion", ParkingSlots.class, String.class);
	}
}
