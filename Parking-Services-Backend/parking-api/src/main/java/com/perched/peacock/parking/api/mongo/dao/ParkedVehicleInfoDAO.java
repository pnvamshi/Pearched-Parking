package com.perched.peacock.parking.api.mongo.dao;

import java.util.List;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkedVehicleInfoDAO {

	/**
	 * 
	 * @param parkedVehicleInfo
	 * @return
	 */
	boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo);

	/**
	 * 
	 * @param vehicleNumber
	 * @return
	 */
	ParkedVehicleInfo getParkedVehicleInfo(String vehicleNumber);

	/**
	 * 
	 * @param vehicleNumber
	 * @param parkingFee
	 * @return
	 */
	boolean exitParking(String vehicleNumber, Double parkingFee);

	/**
	 * 
	 * @param parkingLotId
	 * @return
	 */
	List<String> getParkedVehicles(String parkingLotId);

}
