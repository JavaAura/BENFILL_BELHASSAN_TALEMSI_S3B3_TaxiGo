package io.benfill.TaxiGo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Address {

	private String city;
	private String neighborhood;
}
