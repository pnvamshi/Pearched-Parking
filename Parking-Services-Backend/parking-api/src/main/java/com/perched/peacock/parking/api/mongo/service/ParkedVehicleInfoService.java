package com.perched.peacock.parking.api.mongo.service;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkedVehicleInfoService {

	/**
	 * 
	 * @param parkedVehicleInfo
	 * @return
	 */
	boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo);

}
