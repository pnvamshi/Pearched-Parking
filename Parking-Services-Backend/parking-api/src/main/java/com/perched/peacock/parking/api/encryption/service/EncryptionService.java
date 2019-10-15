package com.perched.peacock.parking.api.encryption.service;

/**
 * 
 * @author pnvamshi
 *
 */

public interface EncryptionService {

	/**
	 * 
	 * @param plainTextPassword
	 * @return
	 */
	String hashPassword(String plainTextPassword);

	/**
	 * 
	 * @param plainPassword
	 * @param hashedPassword
	 * @return
	 */
	boolean comparePassword(String plainPassword, String hashedPassword);

}
