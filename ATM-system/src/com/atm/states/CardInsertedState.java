package com.atm.states;

import com.atm.core.ATM;
import com.atm.domain.Card;
import com.atm.domain.TransactionType;

public class CardInsertedState implements ATMState {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void enterPin(String pin) {
        if (atm.getBankService().authenticate(atm.getCurrentCard().getCardNumber(), pin)) {
            System.out.println("PIN verified.");
            atm.setState(new AuthenticatedState(atm));
        } else {
            System.out.println("Incorrect PIN. Please try again.");
            // In a real ATM, this would have retry logic. For simplicity, we eject.
            ejectCard();
        }
    }
    
    @Override
    public void ejectCard() {
        atm.getCardReader().ejectCard();
        atm.setCurrentCard(null);
        atm.setState(new IdleState(atm));
        System.out.println("Card ejected.");
    }

    // Invalid operations
    @Override
    public void insertCard(Card card) { System.out.println("A card is already inserted."); }
    @Override
    public void selectTransaction(TransactionType type) { System.out.println("Please enter your PIN first."); }
    @Override
    public void withdraw(double amount) { System.out.println("Please enter your PIN first."); }
    @Override
    public void checkBalance() { System.out.println("Please enter your PIN first."); }
}