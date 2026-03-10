package com.gorakh.lldrunner.hotelmanagementsystem.app;

public class CreditCardPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
