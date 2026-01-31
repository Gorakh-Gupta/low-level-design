package com.gorakh.lldrunner.splitwise;

import com.gorakh.lldrunner.splitwise.split.EqualSplit;
import com.gorakh.lldrunner.splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private final String id;
    private final double amount;
    private final String description;
    private final User expenser;
    private final List<Split> splits;

    public Expense(String id, double amount, String description, User expenser) {
        this.id = id;
        this.expenser = expenser;
        this.description = description;
        this.amount = amount;
        this.splits = new ArrayList<>();
    }


    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public User getExpenser() {
        return expenser;
    }

    public List<Split> getSplits() {
        return splits;
    }


    public void addSplit(Split split) {
        splits.add(split);
    }
}
