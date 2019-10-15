package com.perched.peacock.parking.api.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author pnvamshi
 *
 */

@Document(collection = "USER_PROFILE_INFO")
public class UserProfileInfo {

	private String userName;
	
	private String password;
	
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
