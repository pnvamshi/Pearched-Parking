package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class UserAlreadExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserAlreadExistException() {
		super();
	}

	public UserAlreadExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAlreadExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadExistException(String message) {
		super(message);
	}

	public UserAlreadExistException(Throwable cause) {
		super(cause);
	}	

}
