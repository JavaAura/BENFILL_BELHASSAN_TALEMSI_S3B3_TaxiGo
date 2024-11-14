package io.benfill.TaxiGo.dao.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import io.benfill.TaxiGo.dao.IDriverDao;
import io.benfill.TaxiGo.dto.driver.DriverDtoAnalytics;
import io.benfill.TaxiGo.model.Driver;
import io.benfill.TaxiGo.model.Reservation;
import io.benfill.TaxiGo.model.StatusCount;
import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.repository.DriverRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DriverDaoImpl implements IDriverDao {

	private final DriverRepository driverRepository;

	@Override
	public DriverDtoAnalytics getAnalytics() {
		DriverDtoAnalytics driverDto = new DriverDtoAnalytics();
		List<Driver> drivers = driverRepository.findAll();

		HashMap<String, Double> occupancyRates = new HashMap<String, Double>();
		StatusCount statusCount = new StatusCount();

		drivers.forEach((driver) -> {
			occupancyRates.put(driver.getFirstName(), getOccupancyRate(driver));
			if (driver.getStatus() != null) {
				if (driver.getStatus() == Status.AVAILABLE) {
					statusCount.setAvailable(statusCount.getAvailable() + 1);
				} else if (driver.getStatus() == Status.UNAVAILABLE) {
					statusCount.setUnavailable(statusCount.getUnavailable() + 1);
				} else {
					statusCount.setInProgress(statusCount.getInProgress() + 1);
				}

			}
		});

		driverDto.setOccupancyRate(occupancyRates);
		driverDto.setDistributionofStatuses(statusCount);
		driverDto.setDriverCount(driverRepository.count());

		return driverDto;
	}

	private long getTotalAvailabilityTime(LocalDateTime availabilityStart, LocalDateTime availabilityEnd) {
		if (availabilityStart != null && availabilityEnd != null) {
			return Duration.between(availabilityStart, availabilityEnd).toHours(); // Time in hours
		}
		return 0;
	}

	private long getTotalReservationTime(List<Reservation> reservations) {

		int totalReservationTime;
		totalReservationTime = reservations.stream()
				.filter(reservation -> reservation.getStartTimeCourse() != 0 && reservation.getEndTimeCourse() != 0) // Assuming
																														// 0
																														// is
																														// invalid
				.mapToInt(reservation -> reservation.getEndTimeCourse() - reservation.getStartTimeCourse()) // Difference
																											// in hours
				.sum();

		return totalReservationTime;
	}

	private double getOccupancyRate(Driver driver) {
		long totalAvailabilityTime = getTotalAvailabilityTime(driver.getAvailabilityStart(),
				driver.getAvailabilityEnd());
		long totalReservationTime = getTotalReservationTime(driver.getReservations());

		if (totalAvailabilityTime > 0) {
			return ((double) totalReservationTime / totalAvailabilityTime) * 100;
		}

		return 0;
	}

}
