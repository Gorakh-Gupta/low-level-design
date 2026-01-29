package com.gorakh.lldrunner.digitalwallet;

import java.util.List;

public class DigitalWalletDemo {
    public static void run() {
        DigitalWallet digitalWallet = DigitalWallet.getInstance();

        // Create users
        User user1 = new User("U001", "John Doe","password123");
        User user2 = new User("U002", "Jane Smith", "password456");
        digitalWallet.createUser(user1);
        digitalWallet.createUser(user2);

        // Create accounts
        Account account1 = new Account("A001", user1, "1234567890");
        Account account2 = new Account("A002", user2, "9876543210");
        digitalWallet.createAccount(account1);
        digitalWallet.createAccount(account2);

        // Add payment methods
        PaymentMethod creditCard = new Creditcard("PM001", user1, "1234567890123456", "12/25", "123");
        PaymentMethod bankAccount = new BankAccount("PM002", user2, "9876543210", "987654321");
        digitalWallet.addPaymentMethod(creditCard);
        digitalWallet.addPaymentMethod(bankAccount);

        // Deposit funds
        account1.deposit(1000.00);
        account2.deposit(500.00);

        // Transfer funds
        digitalWallet.transferFunds(account1, account2, 100.00);

        // Get transaction history
        List<Transaction> transactionHistory1 = digitalWallet.getTransactionHistory(account1);
        List<Transaction> transactionHistory2 = digitalWallet.getTransactionHistory(account2);

        // Transaction History
        System.out.println("Transaction History for Account 1:");
        System.out.println(account1.getBalance());
        for (Transaction transaction : transactionHistory1) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Timestamp: " + transaction.getTimeStamp());
            System.out.println();
        }

        System.out.println("Transaction History for Account 2:");
        System.out.println(account2.getBalance());
        for (Transaction transaction : transactionHistory2) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Timestamp: " + transaction.getTimeStamp());
            System.out.println();
        }

    }
}
