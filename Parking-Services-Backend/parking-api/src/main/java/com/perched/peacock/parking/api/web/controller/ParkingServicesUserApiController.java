package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.exception.TechnicalException;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;
import com.perched.peacock.parking.api.mongo.service.ParkingSlotsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author pnvamshi
 *
 */

@RestController
@RequestMapping("/parking/user/service")
@Api(value = "/parking/user/service", produces = APPLICATION_JSON_VALUE, tags = "Parking User API Service")
public class ParkingServicesUserApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServicesUserApiController.class);
	
	@Autowired
	ParkingSlotsService parkingSlotsService;
	
	@ApiOperation(value = "Get All Parking Regions", notes = "Return All Parking Regions")
	@RequestMapping(value = "get/parking/region", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")
	})
	public List<ParkingRegionInfo>  getParkingRegions(@Valid @RequestBody @ApiParam(value = "value", required = true) String request) {
		LOGGER.info("Saving record for request : {}", request);
		List<ParkingRegionInfo> response = null;
		try {
			response = parkingSlotsService.getParkingRegions();
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", request, e);
			throw new TechnicalException(e);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Get Parking Slot Info", notes = "Return Parking Slot Info")
	@RequestMapping(value = "get/parking/slot/info", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")
	})
	public ParkingSlots  getParkingSlots(@Valid @RequestBody @ApiParam(value = "value", required = true) String parkingLotId) {
		LOGGER.info("Saving record for request : {}", parkingLotId);
		ParkingSlots response = null;
		try {
			response = parkingSlotsService.getParkingSlotsInfo(parkingLotId);
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", parkingLotId, e);
			throw new TechnicalException(e);
		}
		
		return response;
	}
	
}
