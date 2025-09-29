package com.atm.hardware.impl;

import com.atm.hardware.PinPad;

public class SimplePinPad implements PinPad {
    @Override
    public String readPin() {
        // In a real implementation, this would read from hardware
        System.out.println("Reading PIN from keypad...");
        return ""; // Placeholder - in actual implementation would read from keypad
    }
}