package com.snakesandladders.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEventsManager {
    private final Map<EventType, List<IGameObserver>> observers;

    public GameEventsManager() {
        this.observers = new HashMap<>();
        for (EventType type : EventType.values()) {
            observers.put(type, new ArrayList<>());
        }
    }

    public void subscribe(EventType type, IGameObserver listener) {
        observers.get(type).add(listener);
    }

    public void unsubscribe(EventType type, IGameObserver listener) {
        observers.get(type).remove(listener);
    }

    public void notify(GameEvent event) {
        EventType type = event.getType();
        for (IGameObserver observer : observers.get(type)) {
            observer.update(event);
        }
    }
}