package io.benfill.TaxiGo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.benfill.TaxiGo.dto.driver.DriverDtoReq;
import io.benfill.TaxiGo.dto.driver.DriverDtoResp;
import io.benfill.TaxiGo.mapper.DriverMappper;
import io.benfill.TaxiGo.model.Driver;
import io.benfill.TaxiGo.repository.DriverRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverServiceImpl {

	private final DriverRepository driverRepository;
	private final DriverMappper driverMappper;
	
	
	public Optional<Driver> getDriverById(Long id) {
		return driverRepository.findById(id);
	}

	public List<DriverDtoResp> getAllDrivers(){
		List<Driver> drivers = driverRepository.findAll();
		return  drivers.stream().map(d -> driverMappper.convertEntityToDto(d)).toList();
	}
	
	public DriverDtoResp createDriver(DriverDtoReq driverDto){
		Driver driver = driverRepository.save(driverMappper.convertDtoToEntity(driverDto));
		return driverMappper.convertEntityToDto(driver);
	}
}
