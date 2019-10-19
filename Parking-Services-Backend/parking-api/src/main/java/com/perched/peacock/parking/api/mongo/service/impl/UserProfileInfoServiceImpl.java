package com.perched.peacock.parking.api.mongo.service.impl;

import java.util.List;

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

	@Override
	public boolean updateUserProfileInfo(UserProfileInfo userProfileInfo) {
		return userProfileInfoDAO.updateUserProfileInfo(userProfileInfo);
	}

	@Override
	public boolean updateUserProfilePassword(String userName, String password) {
		return userProfileInfoDAO.updateUserProfilePassword(userName, password);
	}
	
	@Override
	public List<String> getUserNames(String role){
		return userProfileInfoDAO.getUserNames(role);
	}
	
}
