package io.benfill.TaxiGo.repository;

import io.benfill.TaxiGo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
