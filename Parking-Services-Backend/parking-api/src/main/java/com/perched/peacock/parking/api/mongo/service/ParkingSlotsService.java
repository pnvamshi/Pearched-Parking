package com.perched.peacock.parking.api.mongo.service;

import java.util.List;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingSlotsService {

	/**
	 * 
	 * @param parkingRegion
	 * @return
	 */
	ParkingSlots getParkingSlotsInfo(String parkingRegion);

	/**
	 * 
	 * @return
	 */
	List<ParkingRegionInfo> getParkingRegions();

	/**
	 * 
	 * @return
	 */
	List<String> getParkingLotIds();

	/**
	 * 
	 * @param parkingSlots
	 * @return
	 */
	boolean saveParkingSlots(ParkingSlots parkingSlots);
}
