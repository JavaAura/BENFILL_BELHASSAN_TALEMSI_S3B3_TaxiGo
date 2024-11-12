package io.benfill.TaxiGo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.benfill.TaxiGo.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
