package com.example.vehiclemanagement.vehicle_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclemanagement.vehicle_api.entity.Vehicle;
import com.example.vehiclemanagement.vehicle_api.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/add/vehicle")
	public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
	}

	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/vehicle/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {
		return vehicleService.getVehicleById(id);
	}

//	@PutMapping("/vehicle/{id}")
//	public Vehicle updateVehicle(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle) {
//		return vehicleService.updateVehicle(id, vehicle);
//	}
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		Vehicle updated = vehicleService.updateVehicle(id, vehicle);
		return ResponseEntity.ok(updated);
	}


	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/vehicles/search")
	public List<Vehicle> searchVehicles(@RequestParam(required = false) String fuel,
			@RequestParam(required = false) String city, @RequestParam(required = false) String state) {

		if (fuel != null) {
			return vehicleService.searchByFuel(fuel);
		}
		if (city != null) {
			return vehicleService.searchByCity(city);
		}
		if (state != null) {
			return vehicleService.searchByState(state);
		}
		return List.of(); // empty list if no param
	}
}
