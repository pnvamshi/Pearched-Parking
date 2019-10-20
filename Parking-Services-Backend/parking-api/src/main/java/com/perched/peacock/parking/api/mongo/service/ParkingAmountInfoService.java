package com.perched.peacock.parking.api.mongo.service;

import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingAmountInfoService {

	/**
	 * Service to get the parking charge that will be used to generate bill
	 * @param parkingLotId
	 * @return
	 */
	long getParkingCharge(String parkingLotId);

	/**
	 * Service to save he parking charge that will be used to generate bill
	 * @param parkingAmountInfo
	 * @return
	 */
	boolean saveParkingAmountInfo(ParkingAmountInfo parkingAmountInfo);

}
