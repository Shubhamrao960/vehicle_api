package com.example.vehiclemanagement.vehicle_api.service;

import java.util.List;

import com.example.vehiclemanagement.vehicle_api.entity.Vehicle;

public interface VehicleService {
	Vehicle addVehicle(Vehicle vehicle);

	List<Vehicle> getAllVehicles();

	Vehicle getVehicleById(Long id);

	Vehicle updateVehicle(Long id, Vehicle vehicle);

	void deleteVehicle(Long id);

	List<Vehicle> searchByFuel(String fuel);

	List<Vehicle> searchByCity(String city);

	List<Vehicle> searchByState(String state);
}
