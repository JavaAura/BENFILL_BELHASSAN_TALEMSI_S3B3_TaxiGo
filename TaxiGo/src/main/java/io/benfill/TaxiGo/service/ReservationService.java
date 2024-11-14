package io.benfill.TaxiGo.service;

import io.benfill.TaxiGo.model.Reservation;

public interface ReservationService {
    void createReservation(Reservation reservation);
    Reservation getReservation(int id);
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);
}
