package com.perched.peacock.parking.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author pnvamshi
 *
 */

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.perched.peacock.parking.api"})
public class ParkingApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ParkingApiApplication.class, args);
		LOGGER.info("**********************************************************************");
		LOGGER.info("************PARKING API SERVICE STARTED SUCCESSFULLY *****************"); 
		LOGGER.info("**********************************************************************");
	}
}
