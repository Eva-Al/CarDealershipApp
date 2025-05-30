package com.dealership.app;

import com.dealership.data.vehicle.VehicleMake;
import com.dealership.data.vehicle.VehicleModel;
import com.dealership.data.vehicle.VehicleType;
import com.dealership.models.Vehicle;
import com.dealership.services.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
	 
    public static void main(String[] args) {
    	
    	 
    	
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();
        SalesService salesService = new SalesService();

        while (true) {
            System.out.println("===== Car Dealership Menu ======\r\n"
                    + "1. Add a new vehicle\r\n"
                    + "2. View available vehicles\r\n"
                    + "3. Sell a vehicle\r\n"
                    + "4. View all transactions\r\n"
                    + "5. Exit\r\n"
                    + "=================================\r\n"
                    + "Enter your choice:");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
                continue; // Skip to next iteration of loop
            }
             
			switch(choice) {
            case 1: 
            	 // === Make ===
                System.out.println("Select the vehicle make from the following options:");
                VehicleMake make = null;
                while (make == null) {
                    System.out.println("Select the vehicle make from the following options:");
                    for (VehicleMake t : VehicleMake.values()) {
                        System.out.println("- " + t);
                    }
                    System.out.print("Enter the make: ");
                    String input = scanner.nextLine().trim().toUpperCase();

                    try {
                        make = VehicleMake.valueOf(input); // Try to convert input to enum
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Invalid type. Please choose from the listed options.\n");
                    }
                }

                // === Model ===
                System.out.println("Select the vehicle model from the following options:");
                VehicleModel model = null;
                while (model == null) {
                    System.out.println("Select the vehicle model from the following options:");
                    for (VehicleModel t : VehicleModel.values()) {
                        System.out.println("- " + t);
                    }
                    System.out.print("Enter the model: ");
                    String input = scanner.nextLine().trim().toUpperCase();

                    try {
                        model = VehicleModel.valueOf(input); // Try to convert input to enum
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Invalid type. Please choose from the listed options.\n");
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
                        scanner.nextLine(); // Clear bad input
                    }
                }
                scanner.nextLine(); // Clear newline

                // === VIN ===
                System.out.println("Enter the VIN Number:");
                String vinNumber = scanner.nextLine().trim();
                while (!vinNumber.matches("^[A-HJ-NPR-Z0-9]{17}$")) {
                    System.out.println("Invalid VIN. VIN must be 17 characters (no I, O, or Q). Try again:");
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
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                scanner.nextLine(); // Clear newline

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
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                scanner.nextLine(); // Clear newline

                // === Type ===
  
                VehicleType type = null;
                while (type == null) {
                    System.out.println("Select the vehicle type from the following options:");
                    for (VehicleType t : VehicleType.values()) {
                        System.out.println("- " + t);
                    }
                    System.out.print("Enter the type: ");
                    String input = scanner.nextLine().trim().toUpperCase();

                    try {
                        type = VehicleType.valueOf(input); // Try to convert input to enum
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Invalid type. Please choose from the listed options.\n");
                    }
                }
                
                // Add the vehicle to inventory (you can implement this next)
                Vehicle vehicle = new Vehicle(make, model, year, vinNumber, mileage, price, type);
                inventoryManager.addVehicle(vehicle);
                System.out.println("\n✅ Vehicle added successfully!\n");
                break;
                
            case 2 :  
            	List<Vehicle> vehicleList = inventoryManager.getAllVehicles();

            	if (vehicleList.isEmpty()) {
            	    System.out.println("🚫 No vehicles available in the inventory.");
            	} else {
            	    System.out.println("🚗 Available Vehicles:");
            	    for (Vehicle v : vehicleList) {
            	        System.out.println(v);
            	    }
            	}
                break;
                
            case 3 :  
                break;
                
            case 4 :  
                break;
                
            case 5 :  
           	  System.out.println("Exiting... Thank you!");
           	scanner.close();              
           	return;
           	default:
               System.out.println("Invalid choice. Please select a valid option.");  
            	}       

        }  
       
    }
    
}
