package com.perched.peacock.parking.api.mongo.service.test.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.perched.peacock.parking.api.mongo.service.ParkedVehicleInfoService;
import com.perched.peacock.parking.api.request.IncomingVehicleInfoRequest;
import com.perched.peacock.parking.api.utils.ObjectUtil;

/**
 * 
 * @author pnvamshi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ParkedVehicleInfoServiceImplTest {

	@Autowired
	ParkedVehicleInfoService parkedVehicleInfoService;
	
	@Test
	public void saveVehicle1() {
		IncomingVehicleInfoRequest incomingVehicleInfoRequest = new IncomingVehicleInfoRequest();
		incomingVehicleInfoRequest.setParkingLotId("PS1");
		incomingVehicleInfoRequest.setVehicleNumber("TS 21 EZ 4536");
		incomingVehicleInfoRequest.setVehicleWeight(350.0);
		parkedVehicleInfoService.saveParkedVehicleInfo(ObjectUtil.tranformObject(incomingVehicleInfoRequest) );
	}
	
	@Test
	public void saveVehicle2() {
		IncomingVehicleInfoRequest incomingVehicleInfoRequest = new IncomingVehicleInfoRequest();
		incomingVehicleInfoRequest.setParkingLotId("PS1");
		incomingVehicleInfoRequest.setVehicleNumber("TS 21 EZ 4336");
		incomingVehicleInfoRequest.setVehicleWeight(350.0);
		parkedVehicleInfoService.saveParkedVehicleInfo(ObjectUtil.tranformObject(incomingVehicleInfoRequest) );
	}
	
	@Test
	public void saveVehicle3() {
		IncomingVehicleInfoRequest incomingVehicleInfoRequest = new IncomingVehicleInfoRequest();
		incomingVehicleInfoRequest.setParkingLotId("PS1");
		incomingVehicleInfoRequest.setVehicleNumber("TS 21 EZ 7336");
		incomingVehicleInfoRequest.setVehicleWeight(350.0);
		parkedVehicleInfoService.saveParkedVehicleInfo(ObjectUtil.tranformObject(incomingVehicleInfoRequest) );
	}
}
