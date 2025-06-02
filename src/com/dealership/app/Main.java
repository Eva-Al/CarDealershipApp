package com.dealership.app;

import com.dealership.services.*;
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
                inventoryManager.addVehicle(scanner);
                break;            
            case 2 :  
                inventoryManager.getAllVehicles();
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
