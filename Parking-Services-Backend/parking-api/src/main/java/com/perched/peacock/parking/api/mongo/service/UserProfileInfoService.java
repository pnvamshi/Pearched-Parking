package com.perched.peacock.parking.api.mongo.service;

import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface UserProfileInfoService {

	/**
	 * 
	 * @param userProfileInfo
	 * @return
	 */
	boolean saveUserProfileInfo(UserProfileInfo userProfileInfo);

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean verifyUser(String userName, String password);

}
