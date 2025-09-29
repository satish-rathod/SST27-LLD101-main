package com.atm.util;

import com.atm.domain.Denomination;
import java.util.EnumMap;
import java.util.Map;

public class CashInventory {
    private Map<Denomination, Integer> inventory = new EnumMap<>(Denomination.class);

    public void addCash(Denomination denomination, int count) {
        inventory.put(denomination, inventory.getOrDefault(denomination, 0) + count);
    }

    public boolean hasSufficientCash(Map<Denomination, Integer> required) {
        return required.entrySet().stream()
                .allMatch(entry -> inventory.getOrDefault(entry.getKey(), 0) >= entry.getValue());
    }

    public void updateInventory(Map<Denomination, Integer> dispensed) {
        dispensed.forEach((denom, count) -> {
            inventory.put(denom, inventory.get(denom) - count);
        });
    }
}