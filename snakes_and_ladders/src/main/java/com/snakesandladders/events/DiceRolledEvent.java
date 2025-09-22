package com.snakesandladders.events;

import com.snakesandladders.model.Player;

public class DiceRolledEvent extends GameEvent {
    private final Player player;
    private final int diceValue;

    public DiceRolledEvent(Player player, int diceValue) {
        super(EventType.DICE_ROLLED);
        this.player = player;
        this.diceValue = diceValue;
    }

    public Player getPlayer() { return player; }
    public int getDiceValue() { return diceValue; }
}