package com.perched.peacock.parking.api.mongo.service.test.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.perched.peacock.parking.api.constants.SharedConstants;
import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;
import com.perched.peacock.parking.api.mongo.service.UserProfileInfoService;

/**
 * 
 * @author pnvamshi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserProfileInfoServiceImplTest {

	@Autowired
	private UserProfileInfoService userProfileInfoService;
	
	@Test
	public void saveUser1() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("pnvamshi");
		userProfileInfo.setPassword("hello");
		userProfileInfo.setRole(SharedConstants.ROLE_ADMIN);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
	@Test
	public void saveUser2() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("kirubaharan");
		userProfileInfo.setPassword("hello2");
		userProfileInfo.setRole(SharedConstants.ROLE_OPERATOR);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
	@Test
	public void saveUser3() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("nanda");
		userProfileInfo.setPassword("hello3");
		userProfileInfo.setRole(SharedConstants.ROLE_OPERATOR);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
	@Test
	public void saveUser4() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("sai");
		userProfileInfo.setPassword("hello4");
		userProfileInfo.setRole(SharedConstants.ROLE_OPERATOR);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
	@Test
	public void saveUser5() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("madhu");
		userProfileInfo.setPassword("hello5");
		userProfileInfo.setRole(SharedConstants.ROLE_ADMIN);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
	@Test
	public void saveUser6() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("harsha");
		userProfileInfo.setPassword("hello6");
		userProfileInfo.setRole(SharedConstants.ROLE_OPERATOR);
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
	
}
