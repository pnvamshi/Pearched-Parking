package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class UserDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserDoesNotExistException() {
		super();
	}

	public UserDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDoesNotExistException(String message) {
		super(message);
	}

	public UserDoesNotExistException(Throwable cause) {
		super(cause);
	}
}
