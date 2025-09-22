package com.snakesandladders.events;

import com.snakesandladders.model.Player;

public class PlayerMovedEvent extends GameEvent {
    private final Player player;
    private final int startPosition;
    private final int endPosition;
    private final int diceRoll;

    public PlayerMovedEvent(Player player, int startPosition, int endPosition, int diceRoll) {
        super(EventType.PLAYER_MOVED);
        this.player = player;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.diceRoll = diceRoll;
    }

    public Player getPlayer() { return player; }
    public int getStartPosition() { return startPosition; }
    public int getEndPosition() { return endPosition; }
    public int getDiceRoll() { return diceRoll; }
}