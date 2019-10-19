package com.perched.peacock.parking.api.token.service;

import com.perched.peacock.parking.api.dto.LoginDetails;

/**
 * 
 * @author pnvamshi
 *
 */

public interface TokenService {

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	LoginDetails generateToken(String userName, String password);

	/**
	 * 
	 * @param token
	 * @return
	 */
	String getRoleFromToken(String token);

}
