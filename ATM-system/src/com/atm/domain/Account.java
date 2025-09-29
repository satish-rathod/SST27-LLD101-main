package com.atm.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactionHistory() { return transactionHistory; }
}