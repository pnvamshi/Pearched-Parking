package com.perched.peacock.parking.api.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.mongo.dao.ParkedVehicleInfoDAO;

/**
 * 
 * @author pnvamshi
 *
 */

@Repository
public class ParkedVehicleInfoDAOImpl implements ParkedVehicleInfoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
}
