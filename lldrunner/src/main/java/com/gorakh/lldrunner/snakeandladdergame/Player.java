package com.gorakh.lldrunner.snakeandladdergame;

public class Player {
    private final String name;
    int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPositionAfterSnakeOrLadder) {
        position = newPositionAfterSnakeOrLadder;
    }
}
