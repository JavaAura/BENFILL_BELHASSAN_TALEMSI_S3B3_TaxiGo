package io.benfill.TaxiGo.dto.driver;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.benfill.TaxiGo.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class DriverDtoPost {
	public DriverDtoPost() {
	}

	@NotNull(message = "first name should not be null")
	private String firstName;
	@NotNull(message = "last name should not be null")
	private String lastName;
	@NotNull(message = "status should not be null")
	private Status status;
	@NotNull(message = "availability start should not be null")
	private LocalDateTime availabilityStart;
	@NotNull(message = "availability end should not be null")
	private LocalDateTime availabilityEnd;
}
