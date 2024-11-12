package io.benfill.TaxiGo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ModelNotFoundExceptionHandler {
	
	@ExceptionHandler(value = {ModelNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ExceptionMessage> handleModelNotFound(ModelNotFoundException ex) {
	    ExceptionMessage exceptionMessage = new ExceptionMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	    return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}
}