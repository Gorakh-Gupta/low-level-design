package com.gorakh.lldrunner.chessgame;

public class InvalidMoveException extends RuntimeException {
    InvalidMoveException(String message){
        super(message);
    }
}
