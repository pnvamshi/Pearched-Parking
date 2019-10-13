package com.perched.peacock.parking.api.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 
 * @author pnvamshi
 *
 */

@RestController
@RequestMapping("/parking/user/service")
@Api(value = "/parking/user/service", produces = APPLICATION_JSON_VALUE, tags = "Parking User API Service")
public class ParkingServicesUserApiController {

}
