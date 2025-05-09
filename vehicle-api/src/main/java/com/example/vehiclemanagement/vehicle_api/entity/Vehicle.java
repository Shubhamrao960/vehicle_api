package com.example.vehiclemanagement.vehicle_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@JsonProperty("name")
	private String name;

	@NotBlank
	@JsonProperty("fuel_type")
	private String fuelType;

	@Column(unique = true)
	@NotBlank
	@JsonProperty("registration_no")
	private String registrationNo;

	@NotBlank
	@JsonProperty("owner_name")
	private String ownerName;

	@NotBlank
	@JsonProperty("owner_address")
	private String ownerAddress;

	@NotBlank
	@JsonProperty("city")
	private String city;

	@NotBlank
	@JsonProperty("state")
	private String state;

	// Default constructor
	public Vehicle() {
	}

	// Constructor with fields
	public Vehicle(String name, String fuelType, String registrationNo, String ownerName, String ownerAddress,
			String city, String state) {
		this.name = name;
		this.fuelType = fuelType;
		this.registrationNo = registrationNo;
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
		this.city = city;
		this.state = state;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

