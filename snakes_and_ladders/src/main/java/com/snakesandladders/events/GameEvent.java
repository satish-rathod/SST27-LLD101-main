package com.snakesandladders.events;

public abstract class GameEvent {
    private final EventType type;

    public GameEvent(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}