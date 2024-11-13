package io.benfill.TaxiGo.model;

import lombok.Data;

public @Data class StatusCount {
	private Integer available = 0;
	private Integer inProgress = 0;
	private Integer unavailable = 0;
}
