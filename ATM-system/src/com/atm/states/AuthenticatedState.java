package com.atm.states;

import com.atm.core.ATM;
import com.atm.domain.Card;
import com.atm.domain.TransactionType;
import com.atm.hardware.CashDispenser;
import com.atm.services.BankService;

public class AuthenticatedState implements ATMState {
    private ATM atm;

    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void selectTransaction(TransactionType type) {
        System.out.println("Transaction type selected: " + type);
        // Here you could transition to another state for each transaction if they were more complex
        // For simplicity, we handle them here.
    }
    
    @Override
    public void withdraw(double amount) {
        String cardNumber = atm.getCurrentCard().getCardNumber();
        BankService bankService = atm.getBankService();
        CashDispenser cashDispenser = atm.getCashDispenser();

        if (bankService.getBalance(cardNumber) >= amount) {
            if (cashDispenser.dispenseCash(amount)) {
                bankService.withdraw(cardNumber, amount);
                atm.getPrinter().printReceipt("Withdrawal of " + amount + " successful.");
            } else {
                System.out.println("ATM is unable to dispense this amount. Try a different amount.");
            }
        } else {
            System.out.println("Insufficient funds in your account.");
        }
    }
    
    @Override
    public void checkBalance() {
        double balance = atm.getBankService().getBalance(atm.getCurrentCard().getCardNumber());
        atm.getPrinter().printReceipt("Your current balance is: " + balance);
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
    public void insertCard(Card card) { System.out.println("Please eject the current card first."); }
    @Override
    public void enterPin(String pin) { System.out.println("PIN has already been verified."); }
}