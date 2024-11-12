package io.benfill.TaxiGo.dto.request;

import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto  {

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "License plate is required")
    @Pattern(regexp = "^[A-Za-z0-9]{1,9}$", message = "License plate must be alphanumeric and between 1 to 9 characters")
    private String licensePlate;

    @NotNull(message = "Mileage cannot be null")
    @Size(min = 1, max = 50, message = "Mileage must be between 1 and 50 characters")
    private String mileage;

    @NotBlank(message = "Status cannot be null")
    @Pattern(regexp = "AVAILABLE|IN_PROGRESS|UNAVAILABLE", message = "Invalid status. Must be one of: AVAILABLE, IN_PROGRESS, UNAVAILABLE")
    private String  status;

    @NotBlank(message = "Vehicle type cannot be null")
    @Pattern(regexp = "SEDAN|VAN|MINIBUS", message = "Invalid vehicle type. Must be one of: SEDAN, VAN, MINIBUS")
    private String  type;

}
