package com.perched.peacock.parking.api.mongo.dao;

import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkingAmountInfoDAO {

	/**
	 * 
	 * @param parkingLotId
	 * @return
	 */
	ParkingAmountInfo getParkingAmountInfo(String parkingLotId);

	/**
	 * 
	 * @param parkingAmountInfo
	 * @return
	 */
	boolean saveParkingAmountInfo(ParkingAmountInfo parkingAmountInfo);

}
