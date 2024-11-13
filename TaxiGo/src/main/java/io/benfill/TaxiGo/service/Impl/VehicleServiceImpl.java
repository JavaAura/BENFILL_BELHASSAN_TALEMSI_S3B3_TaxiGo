package io.benfill.TaxiGo.service.impl;

import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.mapper.VehicleMapper;
import io.benfill.TaxiGo.model.Vehicle;
import io.benfill.TaxiGo.repository.VehicleRepository;
import io.benfill.TaxiGo.service.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleResponseDto saveVehicle(@Valid VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequestDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
      return vehicleMapper.toDTO(savedVehicle);
    }
}
