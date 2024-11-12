package io.benfill.TaxiGo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.benfill.TaxiGo.dto.driver.DriverDtoReq;
import io.benfill.TaxiGo.dto.driver.DriverDtoResp;
import io.benfill.TaxiGo.service.impl.DriverServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/drivers")
@AllArgsConstructor
public class DriverController {
	
	private final DriverServiceImpl driverService;

	@GetMapping
	public ResponseEntity<List<DriverDtoResp>> index() {
		List<DriverDtoResp> drivers = driverService.getAllDrivers();

		return ResponseEntity.status(HttpStatus.OK).body(drivers);
	}
	
	@PostMapping
	public ResponseEntity<?> store(@RequestBody @Valid DriverDtoReq dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
		DriverDtoResp savedDriver = driverService.createDriver(dto);
		return ResponseEntity.status(HttpStatus.OK).body(savedDriver);
		
	}

}
