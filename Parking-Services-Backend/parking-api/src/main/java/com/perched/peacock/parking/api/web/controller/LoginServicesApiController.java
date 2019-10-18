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

import com.perched.peacock.parking.api.request.LoginRequest;
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
@RequestMapping("/login/service")
@Api(value = "/login/service", produces = APPLICATION_JSON_VALUE, tags = "Login API Service")
public class LoginServicesApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServicesApiController.class);
	
	@Autowired
	private TokenService tokenService;

	@ApiOperation(value = "Save User Profile info", notes = "Return true if save successful")
	@RequestMapping(value = "get/token", method = {POST}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	public String generateToken(@Valid @RequestBody @ApiParam(value = "value", required = true)LoginRequest loginDetails) {
		String response = "";
		try {
			response = tokenService.generateToken(loginDetails.getUserName(), loginDetails.getPassword());
		}catch(Exception e){
			LOGGER.error("Exception occured while processing request : {} as {}", loginDetails.getUserName(), e);
		}
		
		return response;
	}
}
