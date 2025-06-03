package com.dealership.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String vin;
    private Vehicle vehicle;
    private LocalDate date;
    private double price;

    public Transaction(String vin, Vehicle vehicle, LocalDate date, double price) {
        this.vin = vin;
        this.vehicle = vehicle;
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "VIN='" + vin + '\'' +
                ", Vehicle=" + vehicle +
                ", Date=" + date +
                ", Price=$" + price +
                '}';
    }
}
