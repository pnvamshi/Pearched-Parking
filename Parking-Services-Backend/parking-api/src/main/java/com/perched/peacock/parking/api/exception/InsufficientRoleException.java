package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class InsufficientRoleException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InsufficientRoleException() {
		super();
	}

	public InsufficientRoleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsufficientRoleException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientRoleException(String message) {
		super(message);
	}

	public InsufficientRoleException(Throwable cause) {
		super(cause);
	}

	
}
