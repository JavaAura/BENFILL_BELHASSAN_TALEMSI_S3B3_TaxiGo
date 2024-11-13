package io.benfill.TaxiGo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.benfill.TaxiGo.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query("SELECT r FROM Reservation r WHERE r.driver.id = :driverId")
	List<Reservation> findReservationsByDriverId(@Param("driverId") Long driverId);
}
