package com.perched.peacock.parking.api.mongo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	public void saveUser() {
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setUserName("pnvamshi");
		userProfileInfo.setPassword("hello");
		userProfileInfo.setRole("admin");
		userProfileInfoService.saveUserProfileInfo(userProfileInfo );
	}
}
