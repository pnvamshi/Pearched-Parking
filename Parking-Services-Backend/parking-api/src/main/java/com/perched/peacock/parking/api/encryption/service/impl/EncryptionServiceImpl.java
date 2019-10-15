package com.perched.peacock.parking.api.encryption.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.perched.peacock.parking.api.encryption.service.EncryptionService;

/**
 * 
 * @author pnvamshi
 *
 */

@Service
public class EncryptionServiceImpl implements EncryptionService {

	@Override
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	@Override
	public boolean comparePassword(String plainPassword, String hashedPassword) {
		return (BCrypt.checkpw(plainPassword, hashedPassword));
	}
}
