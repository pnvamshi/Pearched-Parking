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
	 * Service to get to know how many slots are available per region
	 * @param parkingRegion
	 * @return
	 */
	ParkingSlots getParkingSlotsInfo(String parkingRegion);

	/**
	 * Service to get all the available parking regions
	 * @return
	 */
	List<ParkingRegionInfo> getParkingRegions();

	/**
	 * Service to get all the available parking lot id for the all the regions 
	 * @return
	 */
	List<String> getParkingLotIds();

	/**
	 * Service to save parking slot information
	 * @param parkingSlots
	 * @return
	 */
	boolean saveParkingSlots(ParkingSlots parkingSlots);
}
