package com.gorakh.lldrunner.chessgame.pieces;

import com.gorakh.lldrunner.chessgame.Board;
import com.gorakh.lldrunner.chessgame.Cell;
import com.gorakh.lldrunner.chessgame.Color;

public class Knight extends Piece {


    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return false;
    }

}