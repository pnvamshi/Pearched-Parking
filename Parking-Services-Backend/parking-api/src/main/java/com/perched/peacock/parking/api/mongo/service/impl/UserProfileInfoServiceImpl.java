package com.perched.peacock.parking.api.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.encryption.service.EncryptionService;
import com.perched.peacock.parking.api.exception.UserDoesNotExistException;
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
	
	@Autowired
	private EncryptionService encryptionService;
	
	@Override
	public boolean saveUserProfileInfo(UserProfileInfo userProfileInfo) {
		return userProfileInfoDAO.saveUserProfileInfo(userProfileInfo);
	}
	
	@Override
	public boolean verifyUser(String userName, String password) {
		UserProfileInfo userProfileInfo = userProfileInfoDAO.getUserProfileInfo(userName);
		if(userProfileInfo == null) {
			throw new UserDoesNotExistException("Username : " + userName + " does not exist, register first");
		}
		String hashedPassword = userProfileInfo.getPassword();
		return encryptionService.comparePassword(password, hashedPassword);
	}
}
