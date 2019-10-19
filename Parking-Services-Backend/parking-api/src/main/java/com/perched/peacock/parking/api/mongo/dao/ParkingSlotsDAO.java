package com.perched.peacock.parking.api.mongo.dao;

import java.util.List;

import com.perched.peacock.parking.api.mongo.model.ParkingSlots;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingSlotsDAO {

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
	List<String> getParkingRegions();

}
