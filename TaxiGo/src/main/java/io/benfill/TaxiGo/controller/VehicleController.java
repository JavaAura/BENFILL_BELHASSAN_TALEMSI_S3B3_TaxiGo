package io.benfill.TaxiGo.controller;

import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.service.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponseDto addVehicle(@Valid @RequestBody VehicleRequestDto vehicleRequestDto) {
        return vehicleService.saveVehicle(vehicleRequestDto);
    }
}
