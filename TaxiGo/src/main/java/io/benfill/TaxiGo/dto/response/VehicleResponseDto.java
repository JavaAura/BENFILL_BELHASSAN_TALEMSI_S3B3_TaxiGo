package io.benfill.TaxiGo.dto.response;

import io.benfill.TaxiGo.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDto {

    private Long id;

    private String model;

    private String licensePlate;

    private String mileage;

    private Status status;

    private VehicleType type;

    public static VehicleResponseDto fromEntity(Vehicle vehicle) {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.setId(vehicle.getId());
        dto.setModel(vehicle.getModel());
        dto.setLicensePlate(vehicle.getLicensePlate());
        dto.setType(VehicleType.valueOf(vehicle.getType().name()));
        dto.setStatus(Status.valueOf(vehicle.getStatus().name()));
        dto.setMileage(vehicle.getMileage());
        return dto;
    }
}
