package com.perched.peacock.parking.api.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.mongo.dao.ParkedVehicleInfoDAO;
import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.mongo.service.ParkedVehicleInfoService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class ParkedVehicleInfoServiceImpl implements ParkedVehicleInfoService {

	@Autowired
	ParkedVehicleInfoDAO parkedVehicleInfoDAO;
	
	@Override
	public boolean saveParkedVehicleInfo(ParkedVehicleInfo parkedVehicleInfo) {
		return parkedVehicleInfoDAO.saveParkedVehicleInfo(parkedVehicleInfo);
	}
}
