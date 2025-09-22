package com.snakesandladders.main;

import com.snakesandladders.core.GameController;
import com.snakesandladders.model.Board;
import com.snakesandladders.model.Player;
import com.snakesandladders.service.IDice;
import com.snakesandladders.service.StandardDice;
import com.snakesandladders.strategy.IWinningStrategy;
import com.snakesandladders.strategy.ExactLandingStrategy;
import com.snakesandladders.events.GameEventsManager;
import com.snakesandladders.events.EventType;
import com.snakesandladders.view.ConsoleView;
import com.snakesandladders.factory.BoardEntityFactory;
import com.snakesandladders.factory.EntityType;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        // 1. Instantiate dependencies
        Board board = new Board(100);
        // Add special entities using BoardEntityFactory
        BoardEntityFactory entityFactory = new BoardEntityFactory();
        
        // Add some snakes
        board.addEntity(98, entityFactory.createEntity(EntityType.SNAKE, 98, 23));
        board.addEntity(87, entityFactory.createEntity(EntityType.SNAKE, 87, 24));
        board.addEntity(93, entityFactory.createEntity(EntityType.SNAKE, 93, 73));
        board.addEntity(95, entityFactory.createEntity(EntityType.SNAKE, 95, 75));
        board.addEntity(62, entityFactory.createEntity(EntityType.SNAKE, 62, 19));
        board.addEntity(64, entityFactory.createEntity(EntityType.SNAKE, 64, 60));
        board.addEntity(54, entityFactory.createEntity(EntityType.SNAKE, 54, 34));
        board.addEntity(17, entityFactory.createEntity(EntityType.SNAKE, 17, 7));
        
        // Add some ladders
        board.addEntity(1, entityFactory.createEntity(EntityType.LADDER, 1, 38));
        board.addEntity(4, entityFactory.createEntity(EntityType.LADDER, 4, 14));
        board.addEntity(9, entityFactory.createEntity(EntityType.LADDER, 9, 21));
        board.addEntity(21, entityFactory.createEntity(EntityType.LADDER, 21, 42));
        board.addEntity(28, entityFactory.createEntity(EntityType.LADDER, 28, 84));
        board.addEntity(36, entityFactory.createEntity(EntityType.LADDER, 36, 44));
        board.addEntity(51, entityFactory.createEntity(EntityType.LADDER, 51, 67));
        board.addEntity(71, entityFactory.createEntity(EntityType.LADDER, 71, 91));
        board.addEntity(80, entityFactory.createEntity(EntityType.LADDER, 80, 100));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));

        IDice dice = new StandardDice();
        IWinningStrategy winningStrategy = new ExactLandingStrategy();
        GameEventsManager eventManager = new GameEventsManager();

        // 2. Register observers
        ConsoleView consoleView = new ConsoleView();
        eventManager.subscribe(EventType.PLAYER_MOVED, consoleView);
        eventManager.subscribe(EventType.GAME_WON, consoleView);
        eventManager.subscribe(EventType.SNAKE_ENCOUNTERED, consoleView);
        eventManager.subscribe(EventType.LADDER_ENCOUNTERED, consoleView);

        // 3. Inject dependencies into GameController
        GameController gameController = new GameController(board, players, dice, winningStrategy, eventManager);

        // 4. Start the game
        gameController.startGame();
    }
}