package com.atm.states;

import com.atm.core.ATM;
import com.atm.domain.Card;
import com.atm.domain.TransactionType;

public class IdleState implements ATMState {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        if (atm.getCardReader().readCard(card)) {
            atm.setCurrentCard(card);
            atm.setState(new CardInsertedState(atm));
            System.out.println("Card inserted successfully. Please enter your PIN.");
        } else {
            System.out.println("Invalid card. Please try again.");
        }
    }

    // Invalid operations in this state
    @Override
    public void ejectCard() { System.out.println("No card to eject."); }
    @Override
    public void enterPin(String pin) { System.out.println("Please insert a card first."); }
    @Override
    public void selectTransaction(TransactionType type) { System.out.println("Please insert a card first."); }
    @Override
    public void withdraw(double amount) { System.out.println("Please insert a card first."); }
    @Override
    public void checkBalance() { System.out.println("Please insert a card first."); }
}