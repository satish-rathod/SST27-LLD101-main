package com.atm.states;

import com.atm.domain.Card;
import com.atm.domain.TransactionType;

public interface ATMState {
    void insertCard(Card card);
    void ejectCard();
    void enterPin(String pin);
    void selectTransaction(TransactionType type);
    void withdraw(double amount);
    void checkBalance();
}