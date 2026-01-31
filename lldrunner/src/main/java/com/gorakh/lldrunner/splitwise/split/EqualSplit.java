package com.gorakh.lldrunner.splitwise.split;

import com.gorakh.lldrunner.splitwise.User;

public class EqualSplit extends Split{
    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
