package io.benfill.TaxiGo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.benfill.TaxiGo.dto.driver.DriverDtoAvailability;
import io.benfill.TaxiGo.dto.driver.DriverDtoGet;
import io.benfill.TaxiGo.dto.driver.DriverDtoPost;
import io.benfill.TaxiGo.exception.BusinessException;
import io.benfill.TaxiGo.service.impl.DriverServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/drivers")
@AllArgsConstructor
public class DriverController {

	private final DriverServiceImpl driverService;

	@GetMapping
	public ResponseEntity<List<DriverDtoGet>> index(@RequestParam(name = "page", defaultValue = "0") Integer page) {
		List<DriverDtoGet> drivers = driverService.getAllDrivers(page);

		return ResponseEntity.status(HttpStatus.OK).body(drivers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		if (id <= 0) {
			return new ResponseEntity<>("Invalid ID", HttpStatus.BAD_REQUEST);
		}

		DriverDtoGet driver = driverService.getDriverDetails(id);

		return ResponseEntity.status(HttpStatus.FOUND).body(driver);
	}

	@PostMapping
	public ResponseEntity<?> store(@RequestBody @Valid DriverDtoPost dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(),
					HttpStatus.BAD_REQUEST);
		}
		DriverDtoGet savedDriver = driverService.createDriver(dto);
		return ResponseEntity.status(HttpStatus.OK).body(savedDriver);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody @Valid DriverDtoPost dto, @PathVariable Long id,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(),
					HttpStatus.BAD_REQUEST);
		}
		DriverDtoGet savedDriver = driverService.updateDriver(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body(savedDriver);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws BusinessException {
		driverService.deleteDriver(id);
		String messsage = "Driver Deleted successfully";
		return ResponseEntity.status(HttpStatus.OK).body(messsage);
	}

	@GetMapping("/availability/{id}")
	public ResponseEntity<?> getDriverAvailability(@PathVariable Long id) {
		DriverDtoAvailability dto = driverService.CheckDriverAvailability(id);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@GetMapping("analytics")
	public ResponseEntity<?> getDriverAnalytics() {
		return driverService.getAnalytics();
	}

}
