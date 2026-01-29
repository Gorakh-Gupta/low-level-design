package com.gorakh.lldrunner.digitalwallet;

import java.sql.Struct;
import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final Account source;
    private final Account destination;
    private final double amount;
    private final LocalDateTime timeStamp;

    public Transaction(String id, Account source, Account destination, double amount) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Account getSource() {
        return source;
    }

    public Account getDestination() {
        return destination;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
