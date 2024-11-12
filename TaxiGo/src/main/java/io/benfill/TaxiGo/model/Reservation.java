package io.benfill.TaxiGo.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import io.benfill.TaxiGo.model.enums.ReservationStatus;
import io.benfill.TaxiGo.utils.AddressConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "date_time", nullable = false)
	private LocalDateTime dateTime;

	@Convert(converter = AddressConverter.class)
	@Column(name = "departure_address", nullable = false)
	private String departureAddress;

	@Convert(converter = AddressConverter.class)
	@Column(name = "arrival_address", nullable = false)
	private String arrivalAddress;
	
	@Column(name = "price", nullable = false)
	private Integer price;

	@Column(name = "heureDebutCourse" ,nullable = false)
	private Integer heureDebutCourse;

	@Column(name = "heureFinCourse" ,nullable = false)
	private Integer heureFinCourse;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	@Column(name = "distance_km", nullable = false)
	private Double distanceKm;
	
	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;

}
