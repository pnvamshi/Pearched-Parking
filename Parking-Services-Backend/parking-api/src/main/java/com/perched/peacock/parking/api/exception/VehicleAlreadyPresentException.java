package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class VehicleAlreadyPresentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public VehicleAlreadyPresentException() {
		super();
	}

	public VehicleAlreadyPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VehicleAlreadyPresentException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleAlreadyPresentException(String message) {
		super(message);
	}

	public VehicleAlreadyPresentException(Throwable cause) {
		super(cause);
	}

	
}
