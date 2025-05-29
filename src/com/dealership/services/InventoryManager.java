package com.dealership.services;

import java.util.ArrayList;
import java.util.List;

import com.dealership.models.Vehicle;

public class InventoryManager {
	
	private List<Vehicle> vehicles = new ArrayList<>();
	public void addVehicle(Vehicle vehicle) {
				    vehicles.add(vehicle);
		}
		
	}

