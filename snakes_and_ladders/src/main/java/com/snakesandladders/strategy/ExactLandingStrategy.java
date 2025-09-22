package com.snakesandladders.strategy;

import com.snakesandladders.model.Player;
import com.snakesandladders.model.Board;

public class ExactLandingStrategy implements IWinningStrategy {
    @Override
    public boolean hasWon(Player player, Board board) {
        return player.getPosition() == board.getWinningSquare();
    }
}