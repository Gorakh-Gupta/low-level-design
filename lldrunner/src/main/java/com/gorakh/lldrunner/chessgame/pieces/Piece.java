package com.gorakh.lldrunner.chessgame.pieces;


import com.gorakh.lldrunner.chessgame.*;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return color;
    }
}