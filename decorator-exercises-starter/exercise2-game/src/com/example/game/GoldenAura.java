package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrappee) {
        super(wrappee);
    }

    @Override
    public String getSprite() {
        return "golden_" + wrappee.getSprite();
    }

    @Override
    public int getSpeed() {
        return wrappee.getSpeed() + 2;
    }

    @Override
    public int getDamage() {
        return wrappee.getDamage() + 5;
    }

    @Override
    public void move() {
        System.out.println("[Golden Aura] Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Golden Aura] Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}
