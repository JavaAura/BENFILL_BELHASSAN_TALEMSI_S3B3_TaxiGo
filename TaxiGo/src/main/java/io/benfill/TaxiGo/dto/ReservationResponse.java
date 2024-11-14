package io.benfill.TaxiGo.dto;


import io.benfill.TaxiGo.model.Driver;
import io.benfill.TaxiGo.model.Vehicle;
import io.benfill.TaxiGo.model.enums.ReservationStatus;
import io.benfill.TaxiGo.utils.AddressConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
        private Long id;
        private LocalDateTime dateTime;
        private String departureAddress;
        private String arrivalAddress;
        private Integer price;
        private Integer heureDebutCourse;
        private Integer heureFinCourse;
        private ReservationStatus status;
        private Double distanceKm;
}
