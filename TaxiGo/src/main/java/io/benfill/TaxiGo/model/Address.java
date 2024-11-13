package io.benfill.TaxiGo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Address {

	private String city;
	private String neighborhood;
}
