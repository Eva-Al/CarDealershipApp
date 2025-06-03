package com.dealership.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dealership.data.vehicle.VehicleMake;
import com.dealership.data.vehicle.VehicleModel;
import com.dealership.data.vehicle.VehicleType;
import com.dealership.models.Transaction;
import com.dealership.models.Vehicle;

public class SalesService {

	private List<Transaction> transactions = new ArrayList<>();
	
	public SalesService() {
	    Vehicle v1 = new Vehicle(VehicleMake.TOYOTA, VehicleModel.CAMRY, 2021, "1HGCM82633A123456", 25000, 20000, VehicleType.SEDAN);
	    Vehicle v2 = new Vehicle(VehicleMake.HONDA, VehicleModel.CIVIC, 2020, "2HGFA16578H123456", 30000, 18000, VehicleType.SEDAN);
	    Vehicle v3 = new Vehicle(VehicleMake.FORD, VehicleModel.F150, 2022, "1FTFW1EF1EKE12345", 15000, 35000, VehicleType.TRUCK);

	    transactions.add(new Transaction(v1.getVinNumber(), v1, LocalDate.of(2024, 6, 1), v1.getPrice()));
	    transactions.add(new Transaction(v2.getVinNumber(), v2, LocalDate.of(2024, 6, 2), v2.getPrice()));
	    transactions.add(new Transaction(v3.getVinNumber(), v3, LocalDate.of(2024, 6, 3), v3.getPrice()));
	}
	public void recordSale(Vehicle vehicle) 
	{
	    transactions.add(new Transaction(vehicle.getVinNumber(), vehicle, LocalDate.of(2024, 6, 3), vehicle.getPrice()));
		
	}
	public void viewAllTransactions() {
	    if (transactions.isEmpty()) {
	        System.out.println("🚫 No transactions found.");
	    } else {
	        System.out.println("📄 Transaction History:");
	        for (Transaction t : transactions) {
	            System.out.println(t);
	        }
	    }
	}

}
