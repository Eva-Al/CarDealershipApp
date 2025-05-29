package com.dealership.models;

import com.dealership.data.vehicle.VehicleType;

public class Vehicle 
{
	
	
	private String make;

	private String model;

	private int year;

	private String vinNumber;

	private int mileage;

	private double price;

	private VehicleType type; 
	

	public Vehicle(String make, String model, int year, String vinNumber, int mileage, double price, VehicleType type) 
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.vinNumber = vinNumber;
		this.price = price;
		this.type = type;		
	}
	
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
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


	
	
}
