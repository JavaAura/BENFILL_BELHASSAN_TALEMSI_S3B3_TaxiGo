package io.benfill.TaxiGo.dto.driver;

import java.util.HashMap;

import io.benfill.TaxiGo.model.StatusCount;
import lombok.Data;

public @Data class DriverDtoAnalytics {
	
	private HashMap<String, Double> occupancyRate;
	private StatusCount distributionofStatuses;

}
