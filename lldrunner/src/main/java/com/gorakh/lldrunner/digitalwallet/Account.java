package com.gorakh.lldrunner.digitalwallet;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private final User usedBy;
    private final String accountNumber;
    private double balance;
    private final List<Transaction> transactions;

    public Account(String id, User usedBy, String accountNumber) {
        this.id = id;
        this.usedBy = usedBy;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public User getUsedBy() {
        return usedBy;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds in the account.");
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
