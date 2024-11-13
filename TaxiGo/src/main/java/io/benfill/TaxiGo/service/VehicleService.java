package io.benfill.TaxiGo.service;

import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import javax.validation.Valid;

public interface VehicleService {
    VehicleResponseDto saveVehicle(@Valid  VehicleRequestDto vehicleRequestDto);
    VehicleResponseDto updateVehicle(Long id, @Valid VehicleRequestDto vehicleRequestDto);
    String deleteVehicle(Long id);

}
