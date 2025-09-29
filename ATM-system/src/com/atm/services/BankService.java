package com.atm.services;

public interface BankService {
    boolean authenticate(String cardNumber, String pin);
    double getBalance(String cardNumber);
    void withdraw(String cardNumber, double amount);
}