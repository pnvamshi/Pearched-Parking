package com.perched.peacock.parking.api.mongo.dao;

import java.util.List;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingSlotsDAO {

	/**
	 * 
	 * @param parkingLotId
	 * @return
	 */
	ParkingSlots getParkingSlotsInfo(String parkingLotId);

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
