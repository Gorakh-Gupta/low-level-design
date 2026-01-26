package com.gorakh.lldrunner.snakeandladdergame;

public class Dice {
    private static final int maxValue = 6;
    private static final int minValue =1;

    int roll (){
        return (int)((Math.random()*(maxValue - minValue + 1 )) + minValue);
    }
}
