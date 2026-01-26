package com.gorakh.lldrunner.snakeandladdergame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private static final int BOARD_SIZE = 100;
//    private final List<Snake> snakes;
//    private final List<Ladder> ladders;

    private int snakeStart[] = {16,48,64,93};
    private int snakeEnd[] = {6,26,60,73};

    private int ladderStart[] = {1,4,9,21,28,51,80};
    private int ladderEnd[] = {38,14,31,42,84,67,99};


    public Board() {
//        snakes = new ArrayList<>();
//        ladders = new ArrayList<>();
//        initializeSnakesAndLadders();
    }
//    private void initializeSnakesAndLadders(){
//        // Initialize snakes
//        snakes.add(new Snake(16, 6));
//        snakes.add(new Snake(48, 26));
//        snakes.add(new Snake(64, 60));
//        snakes.add(new Snake(93, 73));
//
//        // Initialize ladders
//        ladders.add(new Ladder(1, 38));
//        ladders.add(new Ladder(4, 14));
//        ladders.add(new Ladder(9, 31));
//        ladders.add(new Ladder(21, 42));
//        ladders.add(new Ladder(28, 84));
//        ladders.add(new Ladder(51, 67));
//        ladders.add(new Ladder(80, 99));
//    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public int getNewPositionAfterSnakeOrLadder(int position) {
        for (int i=0;i<4; i++) {
            if (snakeStart[i] == position) {
                return snakeEnd[i];
            }
        }

        for (int i=0;i<7;i++) {
            if (ladderStart[i] == position) {
                return ladderEnd[i];
            }
        }
        return position;
    }

}
