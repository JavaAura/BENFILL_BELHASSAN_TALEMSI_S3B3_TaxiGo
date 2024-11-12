package io.benfill.TaxiGo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.model.enums.VehicleType;
import lombok.Data;

@Entity
@Table(name = "vehicles")
public @Data class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "license_plate")
	private String licensePlate;
	
	@Column(name = "mileage")
	private String mileage;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	
	@OneToMany(mappedBy = "vehicle")
	private List<Reservation> reservations;
	
	
}
