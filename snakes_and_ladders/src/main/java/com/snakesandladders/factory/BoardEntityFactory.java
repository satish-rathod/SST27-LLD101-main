package com.snakesandladders.factory;

import com.snakesandladders.model.entities.IBoardEntity;
import com.snakesandladders.model.entities.Snake;
import com.snakesandladders.model.entities.Ladder;

public class BoardEntityFactory {
    public IBoardEntity createEntity(EntityType type, int start, int end) {
        switch (type) {
            case SNAKE:
                return new Snake(start, end);
            case LADDER:
                return new Ladder(start, end);
            // case WORMHOLE: // Future extension
            //     return new Wormhole(start, end);
            default:
                throw new IllegalArgumentException("Unknown entity type: " + type);
        }
    }
}