package io.benfill.TaxiGo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.benfill.TaxiGo.dto.driver.DriverDtoReq;
import io.benfill.TaxiGo.dto.driver.DriverDtoResp;
import io.benfill.TaxiGo.model.Driver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DriverMappper {
	
	private final ModelMapper modelMapper;
	
	public DriverDtoResp convertEntityToDto(Driver driver) {
		return modelMapper.map(driver, DriverDtoResp.class);
	}

	public Driver convertDtoToEntityResp(DriverDtoResp driverDto) {
		return modelMapper.map(driverDto, Driver.class);
	}
	
	
	public DriverDtoReq convertEntityToDtoReq(Driver driver) {
		return modelMapper.map(driver, DriverDtoReq.class);
	}

	public Driver convertDtoToEntity(DriverDtoReq driverDto) {
		return modelMapper.map(driverDto, Driver.class);
	}

}
