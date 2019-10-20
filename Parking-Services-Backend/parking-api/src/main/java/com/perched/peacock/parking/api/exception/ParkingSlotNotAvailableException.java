package com.perched.peacock.parking.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author pnvamshi
 *
 */

@ResponseStatus(value = HttpStatus.OK)
public class ParkingSlotNotAvailableException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ParkingSlotNotAvailableException() {
		super();
	}

	public ParkingSlotNotAvailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParkingSlotNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingSlotNotAvailableException(String message) {
		super(message);
	}

	public ParkingSlotNotAvailableException(Throwable cause) {
		super(cause);
	}
}
