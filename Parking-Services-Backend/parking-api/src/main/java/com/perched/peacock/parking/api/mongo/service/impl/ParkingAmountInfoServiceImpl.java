package com.perched.peacock.parking.api.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.exception.APIBadRequestException;
import com.perched.peacock.parking.api.mongo.dao.ParkingAmountInfoDAO;
import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;
import com.perched.peacock.parking.api.mongo.service.ParkingAmountInfoService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class ParkingAmountInfoServiceImpl implements ParkingAmountInfoService {

	@Autowired
	ParkingAmountInfoDAO parkingAmountInfoDAO;
	
	@Override
	public long getParkingCharge(String parkingLotId) {
		ParkingAmountInfo parkingAmountInfo = parkingAmountInfoDAO.getParkingAmountInfo(parkingLotId);
		if(parkingAmountInfo==null) {
			throw new APIBadRequestException();
		}
		return parkingAmountInfo.getParkingFee();
	}
	
	@Override
	public boolean saveParkingAmountInfo(ParkingAmountInfo parkingAmountInfo) {
		return parkingAmountInfoDAO.saveParkingAmountInfo(parkingAmountInfo);
	}
}
