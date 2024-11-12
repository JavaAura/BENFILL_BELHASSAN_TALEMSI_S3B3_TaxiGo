package io.benfill.TaxiGo.dto.response;

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

    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Model cannot be null")
    @Size(min = 1, max = 100, message = "Model must be between 1 and 100 characters")
    private String model;

    @NotBlank(message = "License plate cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9]{1,20}$", message = "License plate must be alphanumeric and between 1 to 20 characters")
    private String licensePlate;

    @NotNull(message = "Mileage cannot be null")
    @Size(min = 1, max = 50, message = "Mileage must be between 1 and 50 characters")
    private String mileage;

    @NotBlank(message = "Status cannot be null")
    private Status status;

    @NotBlank(message = "Vehicle type cannot be null")
    private VehicleType type;
}
