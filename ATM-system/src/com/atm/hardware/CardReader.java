package com.atm.hardware;

import com.atm.domain.Card;

public interface CardReader {
    boolean readCard(Card card);
    void ejectCard();
}