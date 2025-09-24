package com.example.parkinglot.services;

import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.ElectricVehicle;
import com.example.parkinglot.models.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private Map<String, Ticket> activeTickets;

    public ParkingLot(int carSpots, int bikeSpots, int busSpots, int evChargerSpots) {
        this.spots = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        
        // Initialize spots
        for (int i = 1; i <= bikeSpots; i++) spots.add(new ParkingSpot("B" + i, false));
        for (int i = 1; i <= evChargerSpots; i++) spots.add(new ParkingSpot("E" + i, true));
        for (int i = 1; i <= carSpots; i++) spots.add(new ParkingSpot("C" + i, false));
        for (int i = 1; i <= busSpots; i++) spots.add(new ParkingSpot("D" + i, false));
    }
    
    public Optional<ParkingSpot> findSpotForVehicle(Vehicle vehicle) {
        boolean wantsCharging = (vehicle instanceof ElectricVehicle) && ((ElectricVehicle) vehicle).wantsCharging();
        
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                // EV wanting charge must get a charger spot
                if (wantsCharging) {
                    if (spot.hasElectricCharger()) return Optional.of(spot);
                } else {
                    // Non-EVs or EVs not wanting charge can park in non-charger spots
                    // For simplicity, we assume any spot fits any vehicle type here.
                    // A real system would have spot sizes.
                    if (!spot.hasElectricCharger()) return Optional.of(spot);
                }
            }
        }
        return Optional.empty(); // No suitable spot found
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Optional<Ticket> getActiveTicket(String ticketId) {
        return Optional.ofNullable(activeTickets.get(ticketId));
    }

    public void exitVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null) {
            ticket.getParkingSpot().removeVehicle();
            activeTickets.remove(ticketId);
        }
    }
}