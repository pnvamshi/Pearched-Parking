package com.perched.peacock.parking.api.mongo.service;

import java.util.List;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkedVehicleInfoService {

	/**
	 * Service to save parked vehicle, parking date is populated to the one at time of saving
	 * @param parkedVehicleInfo
	 * @return
	 */
	boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo);

	/**
	 * Service to get parked vehicle info, if still in parking
	 * @param vehicleNumber
	 * @return
	 */
	ParkedVehicleInfo getParkedVehicleInfo(String vehicleNumber);

	/**
	 * Service to get parking bill at time of exit
	 * @param vehicleNumber
	 * @return
	 */
	Double generateParkingBill(String vehicleNumber);

	/**
	 * Service to get all vehicles parking parked in a particular parking lot
	 * @param parkingLotId
	 * @return
	 */
	List<String> getParkedVehicles(String parkingLotId);

}
