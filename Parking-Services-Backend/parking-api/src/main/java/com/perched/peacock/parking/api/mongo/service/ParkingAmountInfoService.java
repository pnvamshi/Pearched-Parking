package com.perched.peacock.parking.api.mongo.service;

import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingAmountInfoService {

	/**
	 * 
	 * @param parkingLotId
	 * @return
	 */
	long getParkingCharge(String parkingLotId);

	/**
	 * 
	 * @param parkingAmountInfo
	 * @return
	 */
	boolean saveParkingAmountInfo(ParkingAmountInfo parkingAmountInfo);

}
