package com.example.vehiclemanagement.vehicle_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclemanagement.vehicle_api.entity.Vehicle;
import com.example.vehiclemanagement.vehicle_api.exception.VehicleNotFoundException;
import com.example.vehiclemanagement.vehicle_api.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(Long id) {
		return vehicleRepository.findById(id)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id: " + id));
	}

	@Override
	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		Vehicle existing = getVehicleById(id);

		if (vehicle.getName() != null) {
			existing.setName(vehicle.getName());
		}
		if (vehicle.getFuelType() != null) {
			existing.setFuelType(vehicle.getFuelType());
		}
		if (vehicle.getRegistrationNo() != null) {
			existing.setRegistrationNo(vehicle.getRegistrationNo());
		}
		if (vehicle.getOwnerName() != null) {
			existing.setOwnerName(vehicle.getOwnerName());
		}
		if (vehicle.getOwnerAddress() != null) {
			existing.setOwnerAddress(vehicle.getOwnerAddress());
		}
		if (vehicle.getCity() != null) {
			existing.setCity(vehicle.getCity());
		}
		if (vehicle.getState() != null) {
			existing.setState(vehicle.getState());
		}

		return vehicleRepository.save(existing);
	}

	@Override
	public void deleteVehicle(Long id) {
		Vehicle vehicle = getVehicleById(id);
		vehicleRepository.delete(vehicle);
	}

	@Override
	public List<Vehicle> searchByFuel(String fuel) {
		return vehicleRepository.findByFuelType(fuel);
	}

	@Override
	public List<Vehicle> searchByCity(String city) {
		return vehicleRepository.findByCity(city);
	}

	@Override
	public List<Vehicle> searchByState(String state) {
		return vehicleRepository.findByState(state);
	}
}
