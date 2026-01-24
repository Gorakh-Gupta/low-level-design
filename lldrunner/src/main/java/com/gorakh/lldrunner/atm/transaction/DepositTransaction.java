package com.gorakh.lldrunner.atm.transaction;

import com.gorakh.lldrunner.atm.Account;

public class DepositTransaction extends Transaction{
    public DepositTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
