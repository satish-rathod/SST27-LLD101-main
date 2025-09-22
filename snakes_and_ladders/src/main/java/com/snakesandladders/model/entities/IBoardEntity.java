package com.snakesandladders.model.entities;

public interface IBoardEntity {
    int getFinalPosition(int currentPosition); // Returns the position a player should move to after encountering this entity.
    String getEncounterMessage(); // Returns a descriptive message (e.g., "Climbed a ladder!").
}
