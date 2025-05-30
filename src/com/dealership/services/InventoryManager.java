package com.dealership.services;

import java.util.ArrayList;
import java.util.List;

import com.dealership.data.vehicle.VehicleMake;
import com.dealership.data.vehicle.VehicleModel;
import com.dealership.data.vehicle.VehicleType;
import com.dealership.models.Vehicle;

public class InventoryManager {
	
	public InventoryManager()
	{ 
		addVehicle(new Vehicle(VehicleMake.TOYOTA, VehicleModel.CAMRY, 2021, "1HGCM82633A123456", 25000, 20000, VehicleType.SEDAN));
    	addVehicle(new Vehicle(VehicleMake.FORD, VehicleModel.F150, 2019, "1FTFW1EF1EKE12345", 40000, 28000, VehicleType.TRUCK));
	    addVehicle(new Vehicle(VehicleMake.HONDA, VehicleModel.CIVIC, 2022, "2HGFA16578H123456", 12000, 22000, VehicleType.SEDAN));
    	addVehicle(new Vehicle(VehicleMake.CHEVROLET, VehicleModel.TAHOE, 2020, "1GNEK13ZX3R298374", 35000, 35000, VehicleType.SUV));
    	addVehicle(new Vehicle(VehicleMake.TESLA, VehicleModel.MODEL_3, 2023, "5YJ3E1EA7KF317000", 5000, 42000, VehicleType.SEDAN));
    	addVehicle(new Vehicle(VehicleMake.JEEP, VehicleModel.WRANGLER, 2018, "1C4BJWDG5JL123456", 60000, 31000, VehicleType.SUV));
	    addVehicle(new Vehicle(VehicleMake.BMW, VehicleModel.X5, 2021, "5UXCR6C58M9E12345", 22000, 50000, VehicleType.SUV));
	    addVehicle(new Vehicle(VehicleMake.AUDI, VehicleModel.A4, 2022, "WAUEFAFL1CN123456", 15000, 37000, VehicleType.SEDAN));
	    addVehicle(new Vehicle(VehicleMake.HYUNDAI, VehicleModel.ELANTRA, 2020, "KMHD84LF3LU123456", 30000, 19000, VehicleType.SEDAN));
	    addVehicle(new Vehicle(VehicleMake.KIA, VehicleModel.SORENTO, 2019, "5XYKTCA69DG123456", 45000, 26000, VehicleType.SUV));
		
	}
	
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public void addVehicle(Vehicle vehicle) {
				    vehicles.add(vehicle);
	}
	public List<Vehicle> getAllVehicles() {
		// TODO Auto-generated method stub
		return vehicles;
	}
		
	}

