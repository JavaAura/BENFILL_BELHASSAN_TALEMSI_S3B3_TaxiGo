package io.benfill.TaxiGo.service.impl;

import io.benfill.TaxiGo.dto.ValidationGroups;
import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.mapper.VehicleMapper;
import io.benfill.TaxiGo.model.Vehicle;
import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;
import io.benfill.TaxiGo.repository.VehicleRepository;
import io.benfill.TaxiGo.service.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

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

    @Override
    public VehicleResponseDto updateVehicle(Long id, @Validated(ValidationGroups.Update.class) VehicleRequestDto vehicleRequestDto) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle with ID " + id + " not found."));

        if (vehicleRequestDto.getModel() != null) {
            existingVehicle.setModel(vehicleRequestDto.getModel());
        }

        if (vehicleRequestDto.getMileage() != null) {
            existingVehicle.setMileage(vehicleRequestDto.getMileage());
        }

        if (vehicleRequestDto.getStatus() != null) {
            existingVehicle.setStatus(Status.valueOf(vehicleRequestDto.getStatus()));
        }

        if (vehicleRequestDto.getType() != null) {
            existingVehicle.setType(VehicleType.valueOf(vehicleRequestDto.getType()));
        }

        if (vehicleRequestDto.getLicensePlate() != null) {
            existingVehicle.setLicensePlate(vehicleRequestDto.getLicensePlate());
        }

        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

        return vehicleMapper.toDTO(updatedVehicle);
    }

    @Override
    public String deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        vehicleRepository.delete(vehicle);

       return "Vehicle deleted";
    }
}
