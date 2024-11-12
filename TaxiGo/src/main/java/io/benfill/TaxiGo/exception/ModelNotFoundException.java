package io.benfill.TaxiGo.exception;

public class ModelNotFoundException extends RuntimeException {
	 private String message;
	
	public ModelNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
