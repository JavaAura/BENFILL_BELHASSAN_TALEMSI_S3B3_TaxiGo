package io.benfill.TaxiGo.service.impl;

import io.benfill.TaxiGo.model.Reservation;
import io.benfill.TaxiGo.repository.ReservationRepository;
import io.benfill.TaxiGo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl  implements ReservationService {


    private final ReservationRepository reservationRepository;

    @Override
    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(int id) {
        return null;
    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

    @Override
    public void deleteReservation(int id) {

    }
}
