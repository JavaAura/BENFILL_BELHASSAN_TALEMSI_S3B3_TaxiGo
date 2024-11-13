package io.benfill.TaxiGo.dao;

import org.springframework.http.ResponseEntity;

import io.benfill.TaxiGo.dto.driver.DriverDtoAnalytics;
import io.benfill.TaxiGo.model.Driver;

public interface IDriverDao {

	DriverDtoAnalytics getAnalytics();
}