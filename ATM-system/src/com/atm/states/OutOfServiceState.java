package com.atm.states;

import com.atm.domain.Card;
import com.atm.domain.TransactionType;

// A placeholder state for demonstrating extensibility
public class OutOfServiceState implements ATMState {
    // Implementations would prevent all operations and display an "Out of Service" message.
    @Override
    public void insertCard(Card card) {
        System.out.println("ATM is out of service. Please try again later.");
    }

    @Override
    public void ejectCard() {
        System.out.println("ATM is out of service. Please try again later.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("ATM is out of service. Please try again later.");
    }

    @Override
    public void selectTransaction(TransactionType type) {
        System.out.println("ATM is out of service. Please try again later.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("ATM is out of service. Please try again later.");
    }

    @Override
    public void checkBalance() {
        System.out.println("ATM is out of service. Please try again later.");
    }
}