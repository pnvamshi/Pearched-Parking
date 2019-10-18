package com.perched.peacock.parking.api.utils;

import java.util.Date;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.request.IncomingVehicleInfoRequest;

/**
 * 
 * @author pnvamshi
 *
 */

public class ObjectUtil {

	public static ParkedVehicleInfo tranformObject(IncomingVehicleInfoRequest incomingVehicleInfoRequest) {
		ParkedVehicleInfo parkedVehicleInfo = new ParkedVehicleInfo();
		parkedVehicleInfo.setEntryTime(new Date());
		parkedVehicleInfo.setParkingLotId(incomingVehicleInfoRequest.getParkingLotId());
		parkedVehicleInfo.setVehicleNumber(incomingVehicleInfoRequest.getVehicleNumber());
		parkedVehicleInfo.setVehicleWeight(incomingVehicleInfoRequest.getVehicleWeight());
		parkedVehicleInfo.setParkingFee(0.0);
		return parkedVehicleInfo;
	}
}
