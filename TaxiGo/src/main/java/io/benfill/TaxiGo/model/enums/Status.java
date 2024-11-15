package io.benfill.TaxiGo.model.enums;

public enum Status {
	AVAILABLE, IN_PROGRESS, UNAVAILABLE;

	public boolean isConflictWithReservations() {
		return this == AVAILABLE || this == UNAVAILABLE;
	}
}
