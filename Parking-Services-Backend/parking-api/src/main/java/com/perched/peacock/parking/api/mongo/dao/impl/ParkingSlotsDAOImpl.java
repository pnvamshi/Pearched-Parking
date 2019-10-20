package com.perched.peacock.parking.api.mongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
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
	public ParkingSlots getParkingSlotsInfo(String parkingLotId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("parkingLotId").is(parkingLotId));
		return mongoTemplate.findOne(query, ParkingSlots.class);
	}
	
	@Override
	public List<ParkingRegionInfo> getParkingRegions() {
		List<ParkingSlots> parkingSlots = mongoTemplate.findAll(ParkingSlots.class);
		List<ParkingRegionInfo> parkingInfo = new ArrayList<ParkingRegionInfo>();
		for(ParkingSlots slot : parkingSlots) {
			ParkingRegionInfo info = new ParkingRegionInfo();
			info.setParkingLotId(slot.getParkingLotId());
			info.setParkingRegion(slot.getParkingRegion());
			parkingInfo.add(info);
		}
		return parkingInfo;
	}
	
	@Override
	public List<String> getParkingLotIds() {
		return mongoTemplate.findDistinct("pakingLotId", ParkingSlots.class, String.class);
	}
	
	@Override
	public boolean saveParkingSlots(ParkingSlots parkingSlots) {
		return mongoTemplate.save(parkingSlots)!=null;
	}
	
}
