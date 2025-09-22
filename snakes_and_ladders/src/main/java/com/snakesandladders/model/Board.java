package com.snakesandladders.model;

import com.snakesandladders.model.entities.IBoardEntity;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private final int winningSquare;
    private final Map<Integer, IBoardEntity> entities; // Position to BoardEntity

    public Board(int size) {
        this.size = size;
        this.winningSquare = size;
        this.entities = new HashMap<>();
    }

    public void addEntity(int position, IBoardEntity entity) {
        if (position > 0 && position <= size) {
            entities.put(position, entity);
        } else {
            throw new IllegalArgumentException("Entity position out of bounds.");
        }
    }

    public int getNextPosition(int currentPosition, int diceValue) {
        int potentialPosition = currentPosition + diceValue;
        // Basic rule: prevent overshooting winning square
        if (potentialPosition > winningSquare) {
            return currentPosition; // Stay put if overshoot
        }
        return potentialPosition;
    }

    public int getWinningSquare() {
        return winningSquare;
    }

    public IBoardEntity getEntityAt(int position) {
        return entities.get(position);
    }
}