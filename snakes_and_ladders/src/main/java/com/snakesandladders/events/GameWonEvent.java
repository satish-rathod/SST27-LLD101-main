package com.snakesandladders.events;

import com.snakesandladders.model.Player;

public class GameWonEvent extends GameEvent {
    private final Player winner;

    public GameWonEvent(Player winner) {
        super(EventType.GAME_WON);
        this.winner = winner;
    }

    public Player getWinner() { return winner; }
}