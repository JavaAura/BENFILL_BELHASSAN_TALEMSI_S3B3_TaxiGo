package io.benfill.TaxiGo.mapper;

import io.benfill.TaxiGo.dto.VehicleDto;
import io.benfill.TaxiGo.model.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public VehicleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VehicleDto toDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    public Vehicle toEntity(VehicleDto vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
}
