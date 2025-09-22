package com.snakesandladders.model.entities;

public class Ladder implements IBoardEntity {
    private final int startPosition;
    private final int endPosition;

    public Ladder(int startPosition, int endPosition) {
        if (startPosition >= endPosition) {
            throw new IllegalArgumentException("Ladder start position must be less than end position.");
        }
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public int getFinalPosition(int currentPosition) {
        return endPosition;
    }

    @Override
    public String getEncounterMessage() {
        return "Yay! You landed on a ladder and climbed up from " + startPosition + " to " + endPosition + ".";
    }
}