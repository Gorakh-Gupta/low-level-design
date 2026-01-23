package com.gorakh.lldrunner.chessgame.pieces;

import com.gorakh.lldrunner.chessgame.Board;
import com.gorakh.lldrunner.chessgame.Cell;
import com.gorakh.lldrunner.chessgame.Color;

public class Rook extends Piece {


    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return false;
    }
}
