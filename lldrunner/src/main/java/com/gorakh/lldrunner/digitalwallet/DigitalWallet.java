package com.gorakh.lldrunner.digitalwallet;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DigitalWallet {
    public static DigitalWallet instance;
    private final Map<String, User>users;
    private final Map<String , Account> accounts;
    private final Map<String , PaymentMethod>paymentmethods;

    public DigitalWallet() {
        this.users = new ConcurrentHashMap<>();
        this.accounts = new ConcurrentHashMap<>();
        this.paymentmethods = new ConcurrentHashMap<>();
    }


    public static synchronized DigitalWallet getInstance(){
        if(instance == null){
            instance = new DigitalWallet();
        }
        return instance;
    }

    public void createUser(User user1) {
        users.put(user1.getId(), user1);
    }

    public void createAccount(Account account1) {
        accounts.put(account1.getId(), account1);
    }

    public void addPaymentMethod(PaymentMethod paymetmethod) {
        paymentmethods.put(paymetmethod.getId(),paymetmethod);
    }

    public void transferFunds(Account sourceAccount, Account destinationAccount, double amount) {
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);

        String transactionId = "TXN "+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
        Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount, amount);
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory(Account account) {
        return account.getTransactions();
    }
}
