package com.gorakh.lldrunner.atm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    private final Map<String,Account> accounts = new ConcurrentHashMap<>();
    public void createAccount(String accountNumber, double initialBalance){
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccounts(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
