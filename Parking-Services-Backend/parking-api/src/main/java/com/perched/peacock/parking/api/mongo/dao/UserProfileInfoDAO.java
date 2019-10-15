package com.perched.peacock.parking.api.mongo.dao;

import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;

/**
 * 
 * @author pnvamshi
 *
 */

public interface UserProfileInfoDAO {

	/**
	 * 
	 * @param userProfileInfo
	 * @return
	 */
	boolean saveUserProfileInfo(UserProfileInfo userProfileInfo);

	/**
	 * 
	 * @param userName
	 * @return
	 */
	UserProfileInfo getUserProfileInfo(String userName);

}
