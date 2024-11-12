package io.benfill.TaxiGo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.benfill.TaxiGo.model.enums.ReservationStatus;
import io.benfill.TaxiGo.utils.AddressConverter;

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