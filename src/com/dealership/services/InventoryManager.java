package com.dealership.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealership.data.vehicle.VehicleMake;
import com.dealership.data.vehicle.VehicleModel;
import com.dealership.data.vehicle.VehicleType;
import com.dealership.models.Vehicle;

public class InventoryManager {
	
	private List<Vehicle> vehicles = new ArrayList<>();

	
	public InventoryManager()
	{ 
		addVehicle(new Vehicle(VehicleModel.CAMRY.getMake(), VehicleModel.CAMRY, 2021, "1HGCM82633A123456", 25000, 20000, VehicleModel.CAMRY.getType()));
		addVehicle(new Vehicle(VehicleModel.F150.getMake(), VehicleModel.F150, 2019, "1FTFW1EF1EKE12345", 40000, 28000, VehicleModel.F150.getType()));
		addVehicle(new Vehicle(VehicleModel.CIVIC.getMake(), VehicleModel.CIVIC, 2022, "2HGFA16578H123456", 12000, 22000, VehicleModel.CIVIC.getType()));
		addVehicle(new Vehicle(VehicleModel.TAHOE.getMake(), VehicleModel.TAHOE, 2020, "1GNEK13ZX3R298374", 35000, 35000, VehicleModel.TAHOE.getType()));
		addVehicle(new Vehicle(VehicleModel.MODEL_3.getMake(), VehicleModel.MODEL_3, 2023, "5YJ3E1EA7KF317000", 5000, 42000, VehicleModel.MODEL_3.getType()));
		addVehicle(new Vehicle(VehicleModel.WRANGLER.getMake(), VehicleModel.WRANGLER, 2018, "1C4BJWDG5JL123456", 60000, 31000, VehicleModel.WRANGLER.getType()));
		addVehicle(new Vehicle(VehicleModel.X5.getMake(), VehicleModel.X5, 2021, "5UXCR6C58M9E12345", 22000, 50000, VehicleModel.X5.getType()));
		addVehicle(new Vehicle(VehicleModel.A4.getMake(), VehicleModel.A4, 2022, "WAUEFAFL1CN123456", 15000, 37000, VehicleModel.A4.getType()));
		addVehicle(new Vehicle(VehicleModel.ELANTRA.getMake(), VehicleModel.ELANTRA, 2020, "KMHD84LF3LU123456", 30000, 19000, VehicleModel.ELANTRA.getType()));
		addVehicle(new Vehicle(VehicleModel.SORENTO.getMake(), VehicleModel.SORENTO, 2019, "5XYKTCA69DG123456", 45000, 26000, VehicleModel.SORENTO.getType()));
		addVehicle(new Vehicle(VehicleModel.MUSTANG.getMake(), VehicleModel.MUSTANG, 2021, "1FA6P8CF7M5123456", 18000, 33000, VehicleModel.MUSTANG.getType()));
		addVehicle(new Vehicle(VehicleModel.RAV4.getMake(), VehicleModel.RAV4, 2022, "2T3R1RFV9NW123456", 12000, 31000, VehicleModel.RAV4.getType()));

		
	}
	
	
	public void addVehicle(Vehicle vehicle) {
			
		vehicles.add(vehicle);
	}
	public void getAllVehicles() {
		
		if (vehicles.isEmpty()) {
    	    System.out.println("🚫 No vehicles available in the inventory.");
    	} else {
    	    System.out.println("🚗 Available Vehicles:");
    	    for (Vehicle v : vehicles) {
    	        System.out.println(v);
    	    }
    	}
	}


	public void addVehicle(Scanner scanner) {
		// === Make ===
		VehicleMake make = null;
		while (make == null) {
		    System.out.println("Select the vehicle make from the following options:");
		    for (VehicleMake m : VehicleMake.values()) {
		        System.out.println("- " + m);
		    }
		    System.out.print("Enter the make: ");
		    String input = scanner.nextLine().trim().toUpperCase();
		    try {
		        make = VehicleMake.valueOf(input);
		    } catch (IllegalArgumentException e) {
		        System.out.println("❌ Invalid make. Please choose from the listed options.\n");
		    }
		}

		List<VehicleModel> matchingModels = new ArrayList<>();
		for (VehicleModel vm : VehicleModel.values()) {
		    if (vm.getMake() == make) {
		        matchingModels.add(vm);
		    }
		}
		VehicleModel model = null;
    while (model == null) {
        System.out.println("Available models for " + make + ":");
        for (VehicleModel vm : matchingModels) {
            System.out.println("- " + vm);
        }

        System.out.print("Enter the model: ");
        String input = scanner.nextLine().trim().toUpperCase();
        try {
            VehicleModel temp = VehicleModel.valueOf(input);
            if (temp.getMake() == make) {
                model = temp;
            } else {
                System.out.println("❌ Model does not match selected make.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid model.");
        }
    }

    // === Year ===
    int year = 0;
    int currentYear = LocalDate.now().getYear();
    while (true) {
        System.out.println("Enter the year (1990 to " + currentYear + "):");
        try {
            year = scanner.nextInt();
            if (year >= 1990 && year <= currentYear) break;
            else System.out.println("Year must be between 1990 and " + currentYear);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid year.");
            scanner.nextLine();
        }
    }
    scanner.nextLine();

    // === VIN ===
    System.out.println("Enter the VIN Number:");
    String vinNumber = scanner.nextLine().trim();
    while (!vinNumber.matches("^[A-HJ-NPR-Z0-9]{17}$")) {
        System.out.println("Invalid VIN. Must be 17 characters (no I, O, Q). Try again:");
        vinNumber = scanner.nextLine().trim();
    }

    // === Mileage ===
    int mileage = 0;
    while (true) {
        System.out.println("Enter the mileage (0 to 250000):");
        try {
            mileage = scanner.nextInt();
            if (mileage >= 0 && mileage <= 250000) break;
            else System.out.println("Mileage must be between 0 and 250000.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid mileage.");
            scanner.nextLine();
        }
    }
    scanner.nextLine();

    // === Price ===
    double price = 0;
    while (true) {
        System.out.println("Enter the price (100 to 200000):");
        try {
            price = scanner.nextDouble();
            if (price >= 100 && price <= 200000) break;
            else System.out.println("Price must be between $100 and $200,000.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid price.");
            scanner.nextLine();
        }
    }
    scanner.nextLine();

    // === Get type from selected model ===
    VehicleType type = model.getType();

    // === Add to list ===
    Vehicle vehicle = new Vehicle(make, model, year, vinNumber, mileage, price, type);
    addVehicle(vehicle); // ← Important: don't forget to add it!
    System.out.println("\n✅ Vehicle added successfully!\n");
}
}


