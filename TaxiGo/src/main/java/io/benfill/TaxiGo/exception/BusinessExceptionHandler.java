package io.benfill.TaxiGo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BusinessExceptionHandler {
	@ExceptionHandler(value = {BusinessException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionMessage> handleModelNotFound(BusinessException ex) {
	    ExceptionMessage exceptionMessage = new ExceptionMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
	}
}
