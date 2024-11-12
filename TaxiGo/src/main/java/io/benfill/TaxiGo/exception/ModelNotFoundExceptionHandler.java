package io.benfill.TaxiGo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ModelNotFoundExceptionHandler {
	
	
	@ExceptionHandler(value = {ModelNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionMessage handleModelNotFound(ModelNotFoundException ex) {
		return new ExceptionMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		
	}

}
