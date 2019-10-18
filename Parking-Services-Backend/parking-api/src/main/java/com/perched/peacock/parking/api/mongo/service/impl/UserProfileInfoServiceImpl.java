package com.perched.peacock.parking.api.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.mongo.dao.UserProfileInfoDAO;
import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;
import com.perched.peacock.parking.api.mongo.service.UserProfileInfoService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class UserProfileInfoServiceImpl implements UserProfileInfoService{

	@Autowired
	private UserProfileInfoDAO userProfileInfoDAO;
	
	@Override
	public boolean saveUserProfileInfo(UserProfileInfo userProfileInfo) {
		return userProfileInfoDAO.saveUserProfileInfo(userProfileInfo);
	}
	
	@Override
	public UserProfileInfo getUserProfileInfo(String userName) {
		return userProfileInfoDAO.getUserProfileInfo(userName);
	}
}
