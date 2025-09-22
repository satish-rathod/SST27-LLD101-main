package com.snakesandladders.model.entities;

public class Snake implements IBoardEntity {
    private final int startPosition;
    private final int endPosition;

    public Snake(int startPosition, int endPosition) {
        if (startPosition <= endPosition) {
            throw new IllegalArgumentException("Snake start position must be greater than end position.");
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
        return "Oh no! You landed on a snake and slid down from " + startPosition + " to " + endPosition + ".";
    }
}