package com.atm.domain;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Amount: %.2f, Time: %s", type, amount, timestamp);
    }
}