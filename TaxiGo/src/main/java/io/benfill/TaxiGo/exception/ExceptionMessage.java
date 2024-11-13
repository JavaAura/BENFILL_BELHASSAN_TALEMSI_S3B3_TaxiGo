package io.benfill.TaxiGo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ExceptionMessage {
	private int status;
	private String message;
	
}
