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
	
	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#saveUserProfileInfo
	 */
	@Override
	public boolean saveUserProfileInfo(UserProfileInfo userProfileInfo) {
		return userProfileInfoDAO.saveUserProfileInfo(userProfileInfo);
	}
	
	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#getUserProfileInfo
	 */
	@Override
	public UserProfileInfo getUserProfileInfo(String userName) {
		return userProfileInfoDAO.getUserProfileInfo(userName);
	}

	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#updateUserProfileInfo
	 */
	@Override
	public boolean updateUserProfileInfo(UserProfileInfo userProfileInfo) {
		return userProfileInfoDAO.updateUserProfileInfo(userProfileInfo);
	}

	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#updateUserProfilePassword
	 */
	@Override
	public boolean updateUserProfilePassword(String userName, String password) {
		return userProfileInfoDAO.updateUserProfilePassword(userName, password);
	}
	
	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#getUserNames
	 */
	@Override
	public List<String> getUserNames(String role){
		return userProfileInfoDAO.getUserNames(role);
	}
	
	/**
	 * @see com.perched.peacock.parking.api.mongo.service.UserProfileInfoService#
	 */
	@Override
	public boolean deleteUserProfile(String username) {
		return userProfileInfoDAO.deleteUserProfile(username);
	}
	
	
}
