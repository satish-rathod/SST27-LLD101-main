package com.snakesandladders.model;

import com.snakesandladders.model.entities.IBoardEntity;

public class Cell {
    private final int number;
    private IBoardEntity entity;

    public Cell(int number) {
        this.number = number;
        this.entity = null;
    }

    public int getNumber() {
        return number;
    }

    public IBoardEntity getEntity() {
        return entity;
    }

    public void setEntity(IBoardEntity entity) {
        this.entity = entity;
    }

    public boolean hasEntity() {
        return entity != null;
    }
}