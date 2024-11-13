package io.benfill.TaxiGo.service;

import java.util.List;
import java.util.Optional;

import io.benfill.TaxiGo.dto.driver.DriverDtoPost;
import io.benfill.TaxiGo.exception.BusinessException;
import io.benfill.TaxiGo.dto.driver.DriverDtoAnalytics;
import io.benfill.TaxiGo.dto.driver.DriverDtoAvailability;
import io.benfill.TaxiGo.dto.driver.DriverDtoGet;
import io.benfill.TaxiGo.model.Driver;

public interface IDriverService {
	public Optional<Driver> getDriverById(Long id);
	public DriverDtoGet getDriverDetails(long id);
	public List<DriverDtoGet> getAllDrivers();
	public DriverDtoGet createDriver(DriverDtoPost driverDto);
	public DriverDtoGet updateDriver(DriverDtoPost driverDto);
	void deleteDriver(Long id) throws BusinessException;
	DriverDtoAvailability CheckDriverAvailability(Long id);
	DriverDtoAnalytics getDriverAnalytics(Long id);
	Long count();
		
}
