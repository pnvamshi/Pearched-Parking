package com.perched.peacock.parking.api.dto;

/**
 * 
 * @author pnvamshi
 *
 */

public class LoginDetails {

	String token;
	String role;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
