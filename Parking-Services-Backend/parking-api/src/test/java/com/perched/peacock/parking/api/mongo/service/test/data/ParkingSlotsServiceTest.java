package com.perched.peacock.parking.api.mongo.service.test.data;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.perched.peacock.parking.api.dto.ParkingRegionInfo;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;
import com.perched.peacock.parking.api.mongo.service.ParkingSlotsService;

/**
 * 
 * @author pnvamshi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ParkingSlotsServiceTest {

	@Autowired
	ParkingSlotsService parkingSlotsService;
	
	@Test
	public void saveParkingSlots1() {
		ParkingSlots parkingSlots = new ParkingSlots();
		parkingSlots.setAvailableSlots(100);
		parkingSlots.setParkingLotId("PS1");
		parkingSlots.setParkingRegion("Phoenix Building");
		parkingSlots.setTotalSlots(150);
		parkingSlotsService.saveParkingSlots(parkingSlots );
	}
	
	@Test
	public void testRegion() {
		List <ParkingRegionInfo> pa = parkingSlotsService.getParkingRegions();
		System.out.println(pa);
	}
}
