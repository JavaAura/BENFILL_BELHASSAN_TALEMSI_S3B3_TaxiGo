package io.benfill.TaxiGo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.benfill.TaxiGo.dto.driver.DriverDtoPost;
import io.benfill.TaxiGo.dto.driver.DriverDtoGet;
import io.benfill.TaxiGo.model.Driver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DriverMappper {
	
	private final ModelMapper modelMapper;
	
	public DriverDtoGet convertEntityToDto(Driver driver) {
		return modelMapper.map(driver, DriverDtoGet.class);
	}

	public Driver convertDtoToEntityResp(DriverDtoGet driverDto) {
		return modelMapper.map(driverDto, Driver.class);
	}
	
	
	public DriverDtoPost convertEntityToDtoReq(Driver driver) {
		return modelMapper.map(driver, DriverDtoPost.class);
	}

	public Driver convertDtoToEntity(DriverDtoPost driverDto) {
		return modelMapper.map(driverDto, Driver.class);
	}

}
