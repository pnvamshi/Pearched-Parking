package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class InvalidTokenException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super();
	}

	public InvalidTokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTokenException(String message) {
		super(message);
	}

	public InvalidTokenException(Throwable cause) {
		super(cause);
	}

}
