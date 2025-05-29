package com.dealership.app;

import com.dealership.data.vehicle.VehicleType;
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

            if (choice == 1) {
                // === Make ===
                System.out.println("Enter the make:");
                String make = scanner.nextLine().trim();
                while (!make.matches("^[A-Za-z ]+$")) {
                    System.out.println("Invalid input. Please enter only letters.");
                    make = scanner.nextLine().trim();
                }

                // === Model ===
                System.out.println("Enter the model:");
                String model = scanner.nextLine().trim();
                while (!model.matches("^[A-Za-z ]+$")) {
                    System.out.println("Invalid input. Please enter only letters.");
                    model = scanner.nextLine().trim();
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
                List<String> allowedTypes = Arrays.asList("SEDAN", "SUV", "TRUCK", "COUPE", "HATCHBACK", "VAN");
                System.out.println("Select the vehicle type from the following options:");
                System.out.println(String.join(", ", allowedTypes));
                System.out.print("Enter the type: ");
                String type = scanner.nextLine().trim().toUpperCase();
                while (!allowedTypes.contains(type)) {
                    System.out.println("Invalid type. Please enter one of the following:");
                    System.out.println(String.join(", ", allowedTypes));
                    System.out.print("Try again: ");
                    type = scanner.nextLine().trim().toUpperCase();
                }

                // Placeholder: Add the vehicle to inventory (you can implement this next)
                System.out.println("\n✅ Vehicle added successfully!\n");
            }

            if (choice == 5) {
                System.out.println("Exiting... Thank you!");
                break;
            }
        }

        scanner.close();
    }
}
