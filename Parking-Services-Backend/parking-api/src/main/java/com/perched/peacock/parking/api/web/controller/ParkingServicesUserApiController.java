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
	public boolean getParkedVehicleInfo(@Valid @RequestBody @ApiParam(value = "value", required = true) ParkedVehicleInfo parkedVehicleInfo) {
		boolean response = false;
		return response;
	}
	
}
