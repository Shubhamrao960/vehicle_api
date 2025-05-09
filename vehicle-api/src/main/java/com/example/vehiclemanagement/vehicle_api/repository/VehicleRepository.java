package com.example.vehiclemanagement.vehicle_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclemanagement.vehicle_api.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	List<Vehicle> findByFuelType(String fuelType);

	List<Vehicle> findByCity(String city);

	List<Vehicle> findByState(String state);
}

