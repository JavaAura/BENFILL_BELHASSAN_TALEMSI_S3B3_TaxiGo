package io.benfill.TaxiGo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class BusinessException extends RuntimeException {
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
