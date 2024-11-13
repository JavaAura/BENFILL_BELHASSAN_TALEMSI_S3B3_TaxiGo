package io.benfill.TaxiGo.dto.request;

import io.benfill.TaxiGo.dto.ValidationGroups;
import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;

import io.benfill.TaxiGo.dto.ValidationGroups.Create;
import io.benfill.TaxiGo.dto.ValidationGroups.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {

    @NotBlank(message = "Model is required", groups = Create.class)
    private String model;

    @NotBlank(message = "License plate is required", groups = Create.class)
    @Pattern(regexp = "^[A-Za-z0-9]{1,9}$", message = "License plate must be alphanumeric and between 1 to 9 characters", groups = {Create.class, Update.class})
    private String licensePlate;

    @NotNull(message = "Mileage cannot be null", groups = Create.class)
    @Size(min = 1, max = 50, message = "Mileage must be between 1 and 50 characters", groups = {Create.class, Update.class})
    private String mileage;

    @NotBlank(message = "Status cannot be null", groups = Create.class)
    @Pattern(regexp = "AVAILABLE|IN_PROGRESS|UNAVAILABLE", message = "Invalid status. Must be one of: AVAILABLE, IN_PROGRESS, UNAVAILABLE", groups = {Create.class, Update.class})
    private String status;

    @NotBlank(message = "Vehicle type cannot be null", groups = Create.class)
    @Pattern(regexp = "SEDAN|VAN|MINIBUS", message = "Invalid vehicle type. Must be one of: SEDAN, VAN, MINIBUS", groups = {Create.class, Update.class})
    private String type;
}
