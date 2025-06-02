package com.dealership.models;

import com.dealership.data.vehicle.VehicleMake;
import com.dealership.data.vehicle.VehicleModel;
import com.dealership.data.vehicle.VehicleType;

public class Vehicle 
{
	
	
	private VehicleMake make;
	private VehicleModel model;

	private int year;

	private String vinNumber;

	private int mileage;

	private double price;

	private VehicleType type; 
	

	public Vehicle(VehicleMake make, VehicleModel model, int year, String vinNumber, int mileage, double price, VehicleType type) 
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.vinNumber = vinNumber;
		this.mileage = mileage;
		this.price = price;
		this.type = type;		
	}
	
	public String getMake() {
		return make.toString();
	}

	public String getModel() {
		return model.toString();
	}

	public int getYear() {
		return year;
	}

	public String getVinNumber() {
		return vinNumber;
	}


	public int getMileage() {
		return mileage;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type.toString();
	}
	@Override
	public String toString() {
	    return make + " " + model + " (" + year + "), VIN: " + vinNumber +
	           ", Mileage: " + mileage + " mi, Price: $" + price +
	           ", Type: " + type;
	}

	
	
}
