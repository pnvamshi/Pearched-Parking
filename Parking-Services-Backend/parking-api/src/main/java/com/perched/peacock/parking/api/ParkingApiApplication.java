package com.perched.peacock.parking.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author pnvamshi
 *
 */

@SpringBootApplication
public class ParkingApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApiApplication.class, args);
		LOGGER.info("**********************************************************************");
		LOGGER.info("************PARKING API SERVICE STARTED SUCCESSFULLY *****************"); 
		LOGGER.info("**********************************************************************");
	}
}
