package io.benfill.TaxiGo.controller;

import io.benfill.TaxiGo.dao.VehicleAnalyticsDto;
import io.benfill.TaxiGo.dto.ValidationGroups;
import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.service.VehicleService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponseDto updateVehicle(
            @PathVariable Long id,
            @Validated(ValidationGroups.Update.class) @RequestBody VehicleRequestDto vehicleRequestDto) {
        return vehicleService.updateVehicle(id, vehicleRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }


    @GetMapping("/analytics")
    public VehicleAnalyticsDto getVehicleAnalytics() {
        return vehicleService.getAnalytics();
    }

    @GetMapping("/all")
    public List<VehicleResponseDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public VehicleResponseDto getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

}
