package com.gorakh.lldrunner.atm.transaction;

import com.gorakh.lldrunner.atm.Account;

public class WithdrawTransaction extends Transaction{
    public WithdrawTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
