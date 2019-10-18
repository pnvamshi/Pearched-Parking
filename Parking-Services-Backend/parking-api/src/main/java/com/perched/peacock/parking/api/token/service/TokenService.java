package com.perched.peacock.parking.api.token.service;

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
	String generateToken(String userName, String password);

	/**
	 * 
	 * @param token
	 * @return
	 */
	String getRoleFromToken(String token);

}
