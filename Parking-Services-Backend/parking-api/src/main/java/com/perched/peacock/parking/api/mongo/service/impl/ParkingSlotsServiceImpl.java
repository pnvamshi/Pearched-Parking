package com.perched.peacock.parking.api.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.mongo.dao.ParkingSlotsDAO;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;
import com.perched.peacock.parking.api.mongo.service.ParkingSlotsService;

@Service
public class ParkingSlotsServiceImpl implements ParkingSlotsService {
	
	@Autowired
	ParkingSlotsDAO parkingSlotsDAO;

	@Override
	public ParkingSlots getParkingSlotsInfo(String parkingRegion) {
		return parkingSlotsDAO.getParkingSlotsInfo(parkingRegion);
	}

	@Override
	public List<ParkingRegionInfo> getParkingRegions() {
		return parkingSlotsDAO.getParkingRegions();
	}

	@Override
	public List<String> getParkingLotIds() {
		return parkingSlotsDAO.getParkingLotIds();
	}
	
	@Override
	public boolean saveParkingSlots(ParkingSlots parkingSlots) {
		return parkingSlotsDAO.saveParkingSlots(parkingSlots);
	}

}
