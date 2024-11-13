package io.benfill.TaxiGo.dto.driver;

import lombok.Data;

public @Data class DriverDtoAvailability {
	private Boolean isAvailable;
	private String message;
}
