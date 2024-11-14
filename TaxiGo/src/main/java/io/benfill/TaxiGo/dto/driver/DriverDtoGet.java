package io.benfill.TaxiGo.dto.driver;

import java.time.LocalDateTime;
import java.util.List;

import io.benfill.TaxiGo.model.Reservation;
import io.benfill.TaxiGo.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class DriverDtoGet {
	private Long id;
	private String firstName;
	private String lastName;
	private Status status;
	private LocalDateTime availabilityStart;
	private LocalDateTime availabilityEnd;
	private List<Reservation> reservations;
}
