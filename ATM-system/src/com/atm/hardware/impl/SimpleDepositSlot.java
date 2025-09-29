package com.atm.hardware.impl;

import com.atm.hardware.DepositSlot;

public class SimpleDepositSlot implements DepositSlot {
    @Override
    public boolean acceptDeposit(double amount) {
        if (amount > 0) {
            System.out.println("Deposit of " + amount + " accepted.");
            return true;
        }
        System.out.println("Invalid deposit amount.");
        return false;
    }
}