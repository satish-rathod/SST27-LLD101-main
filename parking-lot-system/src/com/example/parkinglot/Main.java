package com.example.parkinglot;

import com.example.parkinglot.controllers.EntryGate;
import com.example.parkinglot.controllers.ExitGate;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.Car;
import com.example.parkinglot.models.vehicles.ElectricCar;
import com.example.parkinglot.services.ParkingLot;
import com.example.parkinglot.strategies.PerHourPricingStrategy;
import com.example.parkinglot.strategies.PricingStrategy;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup
        ParkingLot parkingLot = new ParkingLot(5, 10, 2, 3); // car, bike, bus, ev spots
        PricingStrategy pricingStrategy = new PerHourPricingStrategy();
        
        EntryGate entryGate = new EntryGate("Entry1", parkingLot);
        ExitGate exitGate = new ExitGate("Exit1", parkingLot, pricingStrategy);

        // 2. Simulate a regular car entering and exiting
        System.out.println("--- Scenario 1: A Regular Car ---");
        Car car = new Car("KA-01-HH-1234");
        Optional<Ticket> carTicketOpt = entryGate.generateTicket(car);
        
        if (carTicketOpt.isPresent()) {
            Ticket carTicket = carTicketOpt.get();
            System.out.println("Car parked. Ticket ID: " + carTicket.getTicketId());
            
            // Wait for 2 seconds to simulate parking duration
            Thread.sleep(2000); 

            double fee = exitGate.processExitTicket(carTicket.getTicketId());
            System.out.println("Car exited. Fee to be paid: ₹" + fee);
        }
        System.out.println("\n------------------------------------\n");


        // 3. Simulate an Electric Car entering and exiting
        System.out.println("--- Scenario 2: An Electric Car ---");
        ElectricCar evCar = new ElectricCar("DL-02-EV-5678");
        evCar.setWantsChargingFlag(true); // This car wants to charge
        
        Optional<Ticket> evTicketOpt = entryGate.generateTicket(evCar);
        
        if (evTicketOpt.isPresent()) {
            Ticket evTicket = evTicketOpt.get();
            System.out.println("EV Car parked. Ticket ID: " + evTicket.getTicketId());
            
            // Wait for 3 seconds
            Thread.sleep(3000); 

            double fee = exitGate.processExitTicket(evTicket.getTicketId());
            System.out.println("EV Car exited. Fee (including charging) to be paid: ₹" + fee);
        }
    }
}