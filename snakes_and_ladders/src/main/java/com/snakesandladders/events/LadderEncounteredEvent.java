package com.snakesandladders.events;

import com.snakesandladders.model.Player;

public class LadderEncounteredEvent extends GameEvent {
    private final Player player;
    private final int startPosition; // Where player landed on ladder base
    private final int endPosition;   // Where player ended up (ladder top)

    public LadderEncounteredEvent(Player player, int startPosition, int endPosition) {
        super(EventType.LADDER_ENCOUNTERED);
        this.player = player;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Player getPlayer() { return player; }
    public int getStartPosition() { return startPosition; }
    public int getEndPosition() { return endPosition; }
}