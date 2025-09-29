package com.atm.services.impl;

import com.atm.domain.Account;
import com.atm.domain.Transaction;
import com.atm.domain.TransactionType;
import com.atm.services.BankService;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBankService implements BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
    
    @Override
    public boolean authenticate(String cardNumber, String pin) {
        Account account = accounts.get(cardNumber);
        return account != null && account.validatePin(pin);
    }

    @Override
    public double getBalance(String cardNumber) {
        return accounts.getOrDefault(cardNumber, null).getBalance();
    }

    @Override
    public void withdraw(String cardNumber, double amount) {
        Account account = accounts.get(cardNumber);
        if (account != null && account.getBalance() >= amount) {
            account.withdraw(amount);
            account.addTransaction(new Transaction(TransactionType.WITHDRAWAL, amount));
        }
    }
}