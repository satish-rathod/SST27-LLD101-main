package com.atm.domain;

public enum Denomination {
    D_2000(2000),
    D_500(500),
    D_200(200),
    D_100(100);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}