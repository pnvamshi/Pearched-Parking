package com.perched.peacock.parking.api.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.mongo.dao.ParkingAmountInfoDAO;
import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;

/**
 * 
 * @author pnvamshi
 *
 */

@Repository
public class ParkingAmountInfoDAOImpl implements ParkingAmountInfoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public ParkingAmountInfo getParkingAmountInfo(String parkingLotId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("parkingLotId").is(parkingLotId));
		return mongoTemplate.findOne(query, ParkingAmountInfo.class);
	}
	
	@Override
	public boolean saveParkingAmountInfo (ParkingAmountInfo parkingAmountInfo) {
		return mongoTemplate.save(parkingAmountInfo)!=null;
	}
}
