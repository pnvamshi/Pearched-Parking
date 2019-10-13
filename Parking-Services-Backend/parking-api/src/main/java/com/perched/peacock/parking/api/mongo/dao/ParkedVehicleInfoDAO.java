package com.perched.peacock.parking.api.mongo.dao;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface ParkedVehicleInfoDAO {

	boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo);

	ParkedVehicleInfo getParkedVehicleInfo(String vehicleNumber);

}
