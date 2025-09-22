package com.snakesandladders.view;

import com.snakesandladders.events.*;

public class ConsoleView implements IGameObserver {
    @Override
    public void update(GameEvent event) {
        switch (event.getType()) {
            case PLAYER_MOVED:
                PlayerMovedEvent pmEvent = (PlayerMovedEvent) event;
                System.out.println(pmEvent.getPlayer().getName() + " rolled a " + pmEvent.getDiceRoll() +
                                   " and moved from " + pmEvent.getStartPosition() + " to " + pmEvent.getEndPosition() + ".");
                break;
            case GAME_WON:
                GameWonEvent gwEvent = (GameWonEvent) event;
                System.out.println("Congratulations! " + gwEvent.getWinner().getName() + " has won the game!");
                break;
            case SNAKE_ENCOUNTERED:
                SnakeEncounteredEvent seEvent = (SnakeEncounteredEvent) event;
                System.out.println(seEvent.getPlayer().getName() + " " +
                                   "slid down a snake from " + seEvent.getStartPosition() + " to " + seEvent.getEndPosition() + ".");
                break;
            case LADDER_ENCOUNTERED:
                LadderEncounteredEvent leEvent = (LadderEncounteredEvent) event;
                System.out.println(leEvent.getPlayer().getName() + " " +
                                   "climbed a ladder from " + leEvent.getStartPosition() + " to " + leEvent.getEndPosition() + ".");
                break;
            case DICE_ROLLED:
                DiceRolledEvent drEvent = (DiceRolledEvent) event;
                // Already printed by GameController, but could be used for other displays
                break;
            default:
                System.out.println("Received unhandled event: " + event.getType());
                break;
        }
    }
}