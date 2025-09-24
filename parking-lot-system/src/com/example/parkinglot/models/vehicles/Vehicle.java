package com.example.parkinglot.models.vehicles;

public abstract class Vehicle {
    private String vehicleNo;

    public Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleNo() {
        return this.vehicleNo;
    }

    public abstract String getType();
}