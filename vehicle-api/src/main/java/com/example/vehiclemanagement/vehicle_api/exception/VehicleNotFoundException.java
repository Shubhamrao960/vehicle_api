package com.example.vehiclemanagement.vehicle_api.exception;

public class VehicleNotFoundException extends RuntimeException {
	public VehicleNotFoundException(String message) {
		super(message);
	}
}
