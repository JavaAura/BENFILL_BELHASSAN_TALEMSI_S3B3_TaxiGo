package io.benfill.TaxiGo.dto;


import io.benfill.TaxiGo.model.enums.ReservationStatus;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

        @NotBlank(message = "Date Time est obligatoire")
        private LocalDateTime dateTime;

        @NotBlank(message = "Departure Address est obligatoire")
        private String departureAddress;

        @NotBlank(message = "Arrival Address est obligatoire")
        private String arrivalAddress;

        @NotBlank(message = "Le prix est obligatoire")
        private Integer price;

        @NotBlank(message = " heure Debut Course est obligatoire")
        private Integer heureDebutCourse;

        @NotBlank(message = " heure Fin Course est obligatoire")
        private Integer heureFinCourse;

        @NotBlank(message = "status est obligatoire")
        private ReservationStatus status;

        @NotBlank(message = "la distance est obligatoire")
        private Double distanceKm;

        @NotBlank(message = "driver_id est obligatoire")
        private Long driver_id;

        @NotBlank(message = "vehicle_id est obligatoire")
        private Long vehicle_id;


}
