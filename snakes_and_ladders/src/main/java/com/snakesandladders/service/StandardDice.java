package com.snakesandladders.service;

import java.util.Random;

public class StandardDice implements IDice {
    private final Random random;

    public StandardDice() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1; // Generates 1-6
    }
}