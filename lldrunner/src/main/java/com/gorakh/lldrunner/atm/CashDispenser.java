package com.gorakh.lldrunner.atm;

public class CashDispenser {
    private double cashAvailable;
    public CashDispenser(double initialBalance){
        this.cashAvailable = initialBalance;
    }

    public synchronized void dispenseCash(int amount) {
        if (amount > cashAvailable) {
            throw new IllegalArgumentException("Insufficient cash available in the ATM.");
        }
        cashAvailable-=amount;
        System.out.println("Cash dispensed: " + amount);
    }
}

