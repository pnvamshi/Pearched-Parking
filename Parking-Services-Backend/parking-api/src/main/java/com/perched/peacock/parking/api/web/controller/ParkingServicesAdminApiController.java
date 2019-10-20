package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perched.peacock.parking.api.constants.SharedConstants;
import com.perched.peacock.parking.api.exception.InsufficientRoleException;
import com.perched.peacock.parking.api.exception.TechnicalException;
import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;
import com.perched.peacock.parking.api.mongo.service.UserProfileInfoService;
import com.perched.peacock.parking.api.token.service.TokenService;

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
@RequestMapping("/parking/admin/service")
@Api(value = "/parking/admin/service", produces = APPLICATION_JSON_VALUE, tags = "Parking Admin API Service")
public class ParkingServicesAdminApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServicesAdminApiController.class);
	
	@Autowired
	private UserProfileInfoService userProfileInfoService;
	
	@Autowired
	private TokenService tokenService;
	
	
	@ApiOperation(value = "Save User Profile info", notes = "Return true if save successful")
	@RequestMapping(value = "save/user/profile/info", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	public boolean saveUserProfileInfo(@Valid @RequestBody @ApiParam(value = "value", required = true) UserProfileInfo userProfileInfo,@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Saving record for request : {}", userProfileInfo);
		boolean response = false;
		try {
			if(!SharedConstants.ROLE_ADMIN.contains(tokenService.getRoleFromToken(authHeader))) {
				throw new InsufficientRoleException("User does not have access");
			}
			response = userProfileInfoService.saveUserProfileInfo(userProfileInfo);
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", userProfileInfo.getUserName(), e);
			throw new TechnicalException(e);
		}
		
		return response;
	}
	
	@ApiOperation(value = "Get User names", notes = "Return user names")
	@RequestMapping(value = "get/user/names", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	public List<String> getUserNames(@Valid @RequestBody @ApiParam(value = "value", required = true) String role,@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Saving record for request : {}", role);
		List<String> response = null;
		try {
			if(!SharedConstants.ROLE_ADMIN.contains(tokenService.getRoleFromToken(authHeader))) {
				throw new InsufficientRoleException("User does not have access");
			}
			response = userProfileInfoService.getUserNames(role);
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", role, e);
			throw new TechnicalException(e);
		}
		
		return response;
	}
}
