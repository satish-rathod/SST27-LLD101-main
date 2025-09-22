package com.snakesandladders.strategy;

import com.snakesandladders.model.Player;
import com.snakesandladders.model.Board;

public interface IWinningStrategy {
    boolean hasWon(Player player, Board board); // Checks if the player has met winning conditions on the board.
}
