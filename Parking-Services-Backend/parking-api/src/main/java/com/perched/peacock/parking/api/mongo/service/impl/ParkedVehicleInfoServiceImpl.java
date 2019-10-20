package com.perched.peacock.parking.api.mongo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.exception.ParkingSlotNotAvailableException;
import com.perched.peacock.parking.api.exception.TechnicalException;
import com.perched.peacock.parking.api.exception.VehicleNotPresentException;
import com.perched.peacock.parking.api.mongo.dao.ParkedVehicleInfoDAO;
import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.mongo.service.ParkedVehicleInfoService;
import com.perched.peacock.parking.api.mongo.service.ParkingAmountInfoService;
import com.perched.peacock.parking.api.mongo.service.ParkingSlotsService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class ParkedVehicleInfoServiceImpl implements ParkedVehicleInfoService {

	@Autowired
	ParkedVehicleInfoDAO parkedVehicleInfoDAO;
	
	@Autowired
	ParkingSlotsService parkingSlotsService;
	
	@Autowired
	ParkingAmountInfoService parkingAmountInfoService;
	
	@Override
	public boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo) {
		if(parkingSlotsService.getParkingSlotsInfo(parkedVehicleInfo.getParkingLotId()).getAvailableSlots()<1) {
			throw new ParkingSlotNotAvailableException("Parking Slots Not Available");
		}
		return parkedVehicleInfoDAO.saveParkedVehicleInfo(parkedVehicleInfo);
	}
	
	@Override
	public ParkedVehicleInfo getParkedVehicleInfo(String vehicleNumber) {
		return parkedVehicleInfoDAO.getParkedVehicleInfo(vehicleNumber);
	}
	
	@Override
	public Double generateParkingBill(String vehicleNumber) {
		Double parkingAmount = 0.0;
		ParkedVehicleInfo parkedVehicleInfo = parkedVehicleInfoDAO.getParkedVehicleInfo(vehicleNumber);
		if(parkedVehicleInfo == null) {
			throw new VehicleNotPresentException("Vehicle No: "+ vehicleNumber +" already exited or not entered");
		}
		long parkingCharge = parkingAmountInfoService.getParkingCharge(parkedVehicleInfo.getParkingLotId());
		long secs = (new Date().getTime() - parkedVehicleInfo.getEntryTime().getTime()) / 1000;
		long hours = secs / 3600;    
		secs = secs % 3600;
		long mins = secs / 60;
		parkingAmount = (double) ((parkingCharge * hours) + (parkingCharge*mins/60));
		if(!parkedVehicleInfoDAO.exitParking(vehicleNumber, parkingAmount)) {
			throw new TechnicalException("Exception occured while generating bill for : " + vehicleNumber);
		}
		return parkingAmount;
	}
}
