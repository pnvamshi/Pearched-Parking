package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author pnvamshi
 *
 */

@RestController
@RequestMapping("/parking/admin/service")
@Api(value = "/parking/admin/service", produces = APPLICATION_JSON_VALUE, tags = "Parking Operator API Service")
public class ParkingServicesAdminApiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServicesAdminApiController.class);
}
