package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class VehicleNotPresentException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VehicleNotPresentException() {
		super();
	}

	public VehicleNotPresentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VehicleNotPresentException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleNotPresentException(String message) {
		super(message);
	}

	public VehicleNotPresentException(Throwable cause) {
		super(cause);
	}
}
