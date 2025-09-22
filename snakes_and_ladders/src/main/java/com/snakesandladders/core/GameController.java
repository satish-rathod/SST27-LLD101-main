package com.snakesandladders.core;

import com.snakesandladders.model.Board;
import com.snakesandladders.model.Player;
import com.snakesandladders.model.entities.IBoardEntity;
import com.snakesandladders.model.entities.Snake;
import com.snakesandladders.model.entities.Ladder;
import com.snakesandladders.service.IDice;
import com.snakesandladders.strategy.IWinningStrategy;
import com.snakesandladders.events.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameController {
    private final Board board;
    private final Queue<Player> players; // Use LinkedList for Queue
    private final IDice dice;
    private final IWinningStrategy winningStrategy;
    private final GameEventsManager eventManager;
    private Player currentPlayer;
    private boolean isGameWon;

    public GameController(Board board, List<Player> players, IDice dice, IWinningStrategy winningStrategy, GameEventsManager eventManager) {
        this.board = board;
        this.players = new LinkedList<>(players); // Initialize queue
        this.dice = dice;
        this.winningStrategy = winningStrategy;
        this.eventManager = eventManager;
        this.isGameWon = false;
    }

    public void startGame() {
        System.out.println("Game Started!");
        while (!isGameWon) {
            playTurn();
        }
        System.out.println("Game Over!");
    }

    private void playTurn() {
        currentPlayer = players.poll(); // Get current player
        System.out.println("\nIt's " + currentPlayer.getName() + "'s turn. Current position: " + currentPlayer.getPosition());

        int diceValue = dice.roll();
        System.out.println(currentPlayer.getName() + " rolled a " + diceValue);
        
        // Notify of dice roll (optional, for observer)
        eventManager.notify(new DiceRolledEvent(currentPlayer, diceValue));

        processMove(diceValue);

        if (winningStrategy.hasWon(currentPlayer, board)) {
            isGameWon = true;
            eventManager.notify(new GameWonEvent(currentPlayer));
        } else {
            players.add(currentPlayer); // Put current player back at end of queue
        }
    }

    private void processMove(int diceValue) {
        int currentPosition = currentPlayer.getPosition();
        int nextPotentialPosition = currentPosition + diceValue;

        // Apply winning rule (exact landing)
        if (nextPotentialPosition > board.getWinningSquare()) {
            System.out.println(currentPlayer.getName() + " would overshoot the winning square and stays at " + currentPosition);
            eventManager.notify(new PlayerMovedEvent(currentPlayer, currentPosition, currentPosition, diceValue));
            return; // Player does not move
        }

        int finalPosition = board.getNextPosition(currentPosition, diceValue);
        currentPlayer.setPosition(finalPosition);

        eventManager.notify(new PlayerMovedEvent(currentPlayer, currentPosition, finalPosition, diceValue));

        // Check for special entities after initial move calculation
        IBoardEntity entity = board.getEntityAt(finalPosition);
        if (entity != null) {
            int entityStart = finalPosition;
            int entityEnd = entity.getFinalPosition(finalPosition);
            currentPlayer.setPosition(entityEnd);
            System.out.println(entity.getEncounterMessage());
            if (entity instanceof Snake) {
                eventManager.notify(new SnakeEncounteredEvent(currentPlayer, entityStart, entityEnd));
            } else if (entity instanceof Ladder) {
                eventManager.notify(new LadderEncounteredEvent(currentPlayer, entityStart, entityEnd));
            }
            // If chained, potentially re-evaluate
            // For simplicity, current logic assumes a single entity interaction per turn
            // Advanced: loop to check for further chained moves (e.g. ladder to snake)
        }
    }
}