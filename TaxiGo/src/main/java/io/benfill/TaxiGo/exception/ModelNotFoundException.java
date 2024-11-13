package io.benfill.TaxiGo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
	public ModelNotFoundException(String message) {
		super(message);
	}
}
