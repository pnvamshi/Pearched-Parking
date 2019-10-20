package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class APIBadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public APIBadRequestException() {
		super();
	}

	public APIBadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public APIBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public APIBadRequestException(String message) {
		super(message);
	}

	public APIBadRequestException(Throwable cause) {
		super(cause);
	}

}
