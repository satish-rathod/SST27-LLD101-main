package com.snakesandladders.events;

public interface IGameObserver {
    void update(GameEvent event); // Callback method for game events.
}
