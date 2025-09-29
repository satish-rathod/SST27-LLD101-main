package com.atm.hardware.impl;

import com.atm.domain.Card;
import com.atm.hardware.CardReader;

public class SimpleCardReader implements CardReader {
    @Override
    public boolean readCard(Card card) {
        // Simple validation
        return card != null && card.getCardNumber() != null && !card.getCardNumber().isEmpty();
    }

    @Override
    public void ejectCard() {
        System.out.println("Card has been ejected.");
    }
}