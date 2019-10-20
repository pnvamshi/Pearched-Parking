package com.perched.peacock.parking.api.mongo.service.test.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.perched.peacock.parking.api.mongo.model.ParkingAmountInfo;
import com.perched.peacock.parking.api.mongo.model.ParkingSlots;
import com.perched.peacock.parking.api.mongo.service.ParkingAmountInfoService;

/**
 * 
 * @author pnvamshi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ParkingAmountInfoServiceImplTest {
	
	@Autowired
	private ParkingAmountInfoService parkingAmountInfoService;

	@Test
	public void saveParkingAmount1() {
		ParkingAmountInfo parkingAmountInfo = new ParkingAmountInfo();
		parkingAmountInfo.setParkingFee(30);
		parkingAmountInfo.setParkingLotId("PS1");
		parkingAmountInfoService.saveParkingAmountInfo(parkingAmountInfo);
	}
	
	@Test
	public void saveParkingAmount2() {
		ParkingAmountInfo parkingAmountInfo = new ParkingAmountInfo();
		parkingAmountInfo.setParkingFee(20);
		parkingAmountInfo.setParkingLotId("PS2");
		parkingAmountInfoService.saveParkingAmountInfo(parkingAmountInfo);
	}
	
	@Test
	public void saveParkingAmount3() {
		ParkingAmountInfo parkingAmountInfo = new ParkingAmountInfo();
		parkingAmountInfo.setParkingFee(15);
		parkingAmountInfo.setParkingLotId("PS3");
		parkingAmountInfoService.saveParkingAmountInfo(parkingAmountInfo);
	}
}
