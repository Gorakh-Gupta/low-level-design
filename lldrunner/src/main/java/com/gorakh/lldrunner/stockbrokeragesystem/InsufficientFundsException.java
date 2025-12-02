package com.gorakh.lldrunner.stockbrokeragesystem;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
