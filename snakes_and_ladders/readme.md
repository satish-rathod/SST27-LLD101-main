# Snakes and Ladders Game - UML Doc

## Class Diagram

daigram link: https://drive.google.com/file/d/1S9_TlsnEfquajHDTUskF_VwQn2SSB0QC/view?usp=sharing

## file Structure

```
com.snakesandladders/
├── core/              # Game orchestration
│   └── GameController
├── events/            # Observer pattern implementation
│   ├── GameEventsManager
│   ├── GameEvent (abstract)
│   ├── PlayerMovedEvent
│   ├── GameWonEvent
│   ├── LadderEncounteredEvent
│   ├── DiceRolledEvent
│   ├── EventType (enum)
│   └── IGameObserver
├── factory/           # Factory pattern
│   ├── BoardEntityFactory
│   └── EntityType (enum)
├── main/              # Application entry point
│   └── Game
├── model/             # Core domain models
│   ├── Board
│   ├── Cell
│   ├── Player
│   └── entities/
│       ├── IBoardEntity
│       ├── Snake
│       └── Ladder
├── service/           # External services
│   ├── IDice
│   └── StandardDice
├── strategy/          # Strategy pattern
│   ├── IWinningStrategy
│   └── ExactLandingStrategy
└── view/              # Presentation layer
    └── ConsoleView
```

## Game Features

-  10x10 board (100 cells)
-  2-4 players support
-  Standard dice (1-6)
-  Snakes slide players down
-  Ladders move players up
-  Exact landing rule for winning
-  Event-driven architecture
-  Extensible design for new features