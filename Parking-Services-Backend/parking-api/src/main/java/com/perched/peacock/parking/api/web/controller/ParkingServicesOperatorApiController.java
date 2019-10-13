package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perched.peacock.parking.api.mongo.model.ParkedVehicleInfo;
import com.perched.peacock.parking.api.mongo.service.ParkedVehicleInfoService;

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
	@RequestMapping(value = "", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Failure", response = String.class)
	})
	public boolean saveParkedVehicleInfo(@Valid @RequestBody @ApiParam(value = "value", required = true) ParkedVehicleInfo parkedVehicleInfo) {
		LOGGER.info("Saving record for request : {}", parkedVehicleInfo);
		boolean response = false;
		try {
			response = parkedVehicleInfoService.saveParkedVehicleInfo(parkedVehicleInfo);
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", parkedVehicleInfo,e);
		}
		
		return response;
	}
}
