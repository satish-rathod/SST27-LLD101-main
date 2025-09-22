package com.snakesandladders.events;

import com.snakesandladders.model.Player;

public class SnakeEncounteredEvent extends GameEvent {
    private final Player player;
    private final int startPosition; // Where player landed on snake head
    private final int endPosition;   // Where player ended up (snake tail)

    public SnakeEncounteredEvent(Player player, int startPosition, int endPosition) {
        super(EventType.SNAKE_ENCOUNTERED);
        this.player = player;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Player getPlayer() { return player; }
    public int getStartPosition() { return startPosition; }
    public int getEndPosition() { return endPosition; }
}