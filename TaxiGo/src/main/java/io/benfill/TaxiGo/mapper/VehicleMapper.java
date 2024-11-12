package io.benfill.TaxiGo.mapper;

import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.model.Vehicle;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface VehicleMapper {
    Vehicle toEntity(VehicleRequestDto vehicleRequestDto);
    VehicleResponseDto toDTO(Vehicle vehicule);
}
