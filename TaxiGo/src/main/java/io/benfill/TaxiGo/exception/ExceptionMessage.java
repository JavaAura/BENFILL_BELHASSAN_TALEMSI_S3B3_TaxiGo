package io.benfill.TaxiGo.exception;

import lombok.Data;

public @Data class ExceptionMessage {

	private int status;
	private String message;

}
