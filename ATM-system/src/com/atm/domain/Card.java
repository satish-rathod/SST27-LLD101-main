package com.atm.domain;

public class Card {
    private String cardNumber;
    private String cardHolderName;

    public Card(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}