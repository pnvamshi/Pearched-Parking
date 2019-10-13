package com.perched.peacock.parking.api.utils;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.request.IncomingVehicleInfoRequest;

/**
 * 
 * @author pnvamshi
 *
 */

public class TransformObjectUtil {

	public static ParkedVehicleInfo tranformObject(IncomingVehicleInfoRequest incomingVehicleInfoRequest) {
		ParkedVehicleInfo parkedVehicleInfo = new ParkedVehicleInfo();
		parkedVehicleInfo.setEntryTime(incomingVehicleInfoRequest.getEntryTime());
		parkedVehicleInfo.setParkingLotId(incomingVehicleInfoRequest.getParkingLotId());
		parkedVehicleInfo.setVehicleNumber(incomingVehicleInfoRequest.getVehicleNumber());
		parkedVehicleInfo.setVehicleWeight(incomingVehicleInfoRequest.getVehicleWeight());
		return parkedVehicleInfo;
	}
}
