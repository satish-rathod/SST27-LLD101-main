package com.atm.core;

import com.atm.domain.Card;
import com.atm.domain.TransactionType;
import com.atm.hardware.CardReader;
import com.atm.hardware.CashDispenser;
import com.atm.hardware.PinPad;
import com.atm.hardware.Printer;
import com.atm.services.BankService;
import com.atm.states.ATMState;
import com.atm.states.IdleState;

// The context class in the State Pattern
public class ATM {
    private ATMState currentState;
    private CardReader cardReader;
    private PinPad pinPad;
    private CashDispenser cashDispenser;
    private Printer printer;
    private BankService bankService;
    private Card currentCard;

    // Dependencies are injected
    public ATM(CardReader cardReader, PinPad pinPad, CashDispenser cashDispenser, Printer printer, BankService bankService) {
        this.cardReader = cardReader;
        this.pinPad = pinPad;
        this.cashDispenser = cashDispenser;
        this.printer = printer;
        this.bankService = bankService;
        this.currentState = new IdleState(this); // Initial state
    }

    // --- State Management ---
    public void setState(ATMState state) {
        this.currentState = state;
    }

    // --- User Actions Delegated to Current State ---
    public void insertCard(Card card) {
        currentState.insertCard(card);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void selectTransaction(TransactionType type) {
        currentState.selectTransaction(type);
    }

    public void withdraw(double amount) {
        currentState.withdraw(amount);
    }

    public void checkBalance() {
        currentState.checkBalance();
    }

    // --- Getters for hardware and services ---
    public CardReader getCardReader() { return cardReader; }
    public PinPad getPinPad() { return pinPad; }
    public CashDispenser getCashDispenser() { return cashDispenser; }
    public Printer getPrinter() { return printer; }
    public BankService getBankService() { return bankService; }
    public Card getCurrentCard() { return currentCard; }
    public void setCurrentCard(Card card) { this.currentCard = card; }
}