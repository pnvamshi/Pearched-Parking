package com.perched.peacock.parking.api.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.mongo.dao.ParkingSlotsDAO;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;
import com.perched.peacock.parking.api.mongo.service.ParkingSlotsService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class ParkingSlotsServiceImpl implements ParkingSlotsService {
	
	@Autowired
	private ParkingSlotsDAO parkingSlotsDAO;

	/**
	 * @see com.perched.peacock.parking.api.mongo.service.ParkingSlotsService#getParkingSlotsInfo
	 */
	@Override
	public ParkingSlots getParkingSlotsInfo(String parkingRegion) {
		return parkingSlotsDAO.getParkingSlotsInfo(parkingRegion);
	}

	/**
	 * @see com.perched.peacock.parking.api.mongo.service.ParkingSlotsService#getParkingRegions
	 */
	@Override
	public List<ParkingRegionInfo> getParkingRegions() {
		return parkingSlotsDAO.getParkingRegions();
	}

	/**
	 * @see com.perched.peacock.parking.api.mongo.service.ParkingSlotsService#getParkingLotIds
	 */
	@Override
	public List<String> getParkingLotIds() {
		return parkingSlotsDAO.getParkingLotIds();
	}
	
	/**
	 * @see com.perched.peacock.parking.api.mongo.service.ParkingSlotsService#saveParkingSlots
	 */
	@Override
	public boolean saveParkingSlots(ParkingSlots parkingSlots) {
		return parkingSlotsDAO.saveParkingSlots(parkingSlots);
	}

}
