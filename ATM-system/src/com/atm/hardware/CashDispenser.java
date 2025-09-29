package com.atm.hardware;

import com.atm.domain.Denomination;
import com.atm.util.CashInventory;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class CashDispenser {
    private CashInventory inventory;

    public CashDispenser(CashInventory inventory) {
        this.inventory = inventory;
    }

    public boolean dispenseCash(double amount) {
        if (amount <= 0 || amount % 100 != 0) {
            System.out.println("Invalid withdrawal amount. Must be a multiple of 100.");
            return false;
        }

        Map<Denomination, Integer> toDispense = calculateDenominations((int) amount);

        if (toDispense.isEmpty()) {
            System.out.println("Cannot dispense the requested amount with available notes.");
            return false;
        }

        // Check if there's enough cash before actually dispensing
        if (inventory.hasSufficientCash(toDispense)) {
            inventory.updateInventory(toDispense);
            System.out.println("Dispensing cash:");
            toDispense.forEach((denom, count) -> System.out.printf("%d x Rs %d%n", count, denom.getValue()));
            return true;
        } else {
            System.out.println("Insufficient cash in ATM to complete this transaction.");
            return false;
        }
    }
    
    // Greedy algorithm for dispensing
    private Map<Denomination, Integer> calculateDenominations(int amount) {
        Map<Denomination, Integer> result = new TreeMap<>(Collections.reverseOrder());
        int remaining = amount;
        
        for (Denomination denom : Denomination.values()) {
            int value = denom.getValue();
            if (remaining >= value) {
                int count = remaining / value;
                result.put(denom, count);
                remaining %= value;
            }
        }
        
        return (remaining == 0) ? result : Collections.emptyMap();
    }
}