package com.gorakh.lldrunner.digitalwallet;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(String message){
        super(message);
    }

}
