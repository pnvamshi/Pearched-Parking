package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.mongo.service.ParkedVehicleInfoService;
import com.perched.peacock.parking.api.request.IncomingVehicleInfoRequest;
import com.perched.peacock.parking.api.utils.ObjectUtil;

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
@RequestMapping("/parking/operator/service")
@Api(value = "/parking/operator/service", produces = APPLICATION_JSON_VALUE, tags = "Parking Operator API Service")
public class ParkingServicesOperatorApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServicesOperatorApiController.class);
	
	@Autowired
	ParkedVehicleInfoService parkedVehicleInfoService;
	
	@ApiOperation(value = "Save Vehicle info", notes = "Return true if save successful")
	@RequestMapping(value = "save/vehicle/info", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	public boolean saveParkedVehicleInfo(@Valid @RequestBody @ApiParam(value = "value", required = true) IncomingVehicleInfoRequest vehicleInfo) {
		LOGGER.info("Saving record for request : {}", vehicleInfo);
		boolean response = false;
		try {
			response = parkedVehicleInfoService.saveParkedVehicleInfo(ObjectUtil.tranformObject(vehicleInfo));
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", vehicleInfo, e);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Get Vehicle info", notes = "Get Vehicle Info using Vehicle Number")
	@RequestMapping(value = "get/vehicle/info", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")
	})
	public ParkedVehicleInfo getParkedVehicleInfo(@Valid @RequestBody @ApiParam(value = "value", required = true) String vehicleNumber) {
		LOGGER.info("Saving record for request : {}", vehicleNumber);
		ParkedVehicleInfo response = null;
		try {
			response = parkedVehicleInfoService.getParkedVehicleInfo(vehicleNumber);
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", vehicleNumber, e);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Generate Vehicle Parking Bill", notes = "Generate Vehicle Parking Bill")
	@RequestMapping(value = "generate/parking/bill", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")
	})
	public Long generateParkingBill(@Valid @RequestBody @ApiParam(value = "value", required = true) String vehicleNumber) {
		LOGGER.info("Saving record for request : {}", vehicleNumber);
		Long response = null;
		try {
			response = (long) Math.floor(parkedVehicleInfoService.generateParkingBill(vehicleNumber));
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", vehicleNumber, e);
		}
		
		return response;
	}
}
