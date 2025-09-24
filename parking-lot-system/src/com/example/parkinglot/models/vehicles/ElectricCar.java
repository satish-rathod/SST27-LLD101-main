package com.example.parkinglot.models.vehicles;

public class ElectricCar extends Car implements ElectricVehicle {
    private boolean wantsCharging;

    public ElectricCar(String vehicleNo) {
        super(vehicleNo);
        this.wantsCharging = false;
    }

    @Override
    public String getType() {
        return "ElectricCar";
    }

    @Override
    public boolean wantsCharging() {
        return this.wantsCharging;
    }

    @Override
    public void setWantsChargingFlag(boolean flag) {
        this.wantsCharging = flag;
    }
}