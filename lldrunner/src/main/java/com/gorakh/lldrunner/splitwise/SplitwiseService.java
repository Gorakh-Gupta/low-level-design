package com.gorakh.lldrunner.splitwise;

import com.gorakh.lldrunner.splitwise.split.EqualSplit;
import com.gorakh.lldrunner.splitwise.split.PercentSplit;
import com.gorakh.lldrunner.splitwise.split.Split;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitwiseService {
    private static SplitwiseService instance;
    private final Map<String, User> users;
    private final Map<String, Group> groups;

    public SplitwiseService() {
        this.users = new ConcurrentHashMap<>();
        this.groups = new ConcurrentHashMap<>();
    }
    public static  synchronized SplitwiseService getInstance(){
        if(instance == null){
            instance = new SplitwiseService();
        }
        return instance;
    }
    public void addUser(User user){
        users.put(user.getId(), user);
    }

    public void addGroup(Group group) {
        groups.put(group.getId(),group);
    }

    public void addExpense(String id, Expense expense) {
        Group group = groups.get(id);
        if( group != null){
            group.addExpense(expense);
            splitExpense(expense);
            updateBalances(expense);
        }
    }

    private void updateBalances(Expense expense) {
        for (Split split : expense.getSplits()) {
            User paidBy = expense.getExpenser();
            User user = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(user)) {
                updateBalance(paidBy, user, amount);
                updateBalance(user, paidBy, -amount);
            }
        }

    }

    private void updateBalance(User user1, User user2, double amount) {
//        System.out.println(amount + "KKKKKKKKKKKK");
        String key = getBalanceKey(user1, user2);
        user1.getBalances().put(key, user1.getBalances().getOrDefault(key, 0.0) + amount);
    }

    private String getBalanceKey(User user1, User user2) {
        return user1.getId() + ":" + user2.getId();
    }
    private void splitExpense(Expense expense) {
        double totalAmount = expense.getAmount();
        List<Split> splits = expense.getSplits();
        int totalSplits = splits.size();

        double splitAmount = totalAmount / totalSplits;
        for (Split split : splits) {
            if (split instanceof EqualSplit) {
                split.setAmount(splitAmount);
            } else if (split instanceof PercentSplit percentSplit) {
                split.setAmount(totalAmount * percentSplit.getPercent() / 100.0);
            }
        }
    }

    public void settleBalance(String userId1, String userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);

        if (user1 != null && user2 != null) {
            String key = getBalanceKey(user1, user2);
            double balance = user1.getBalances().getOrDefault(key, 0.0);

            if (balance > 0) {
                createTransaction(user1, user2, balance);
//                user1.getBalances().put(key, 0.0);
                user2.getBalances().put(getBalanceKey(user2, user1), balance);
            }  else if (balance <= 0) {
                createTransaction(user2, user1, Math.abs(balance));
//                user1.getBalances().put(key, 0.0);
                user2.getBalances().put(getBalanceKey(user1, user2), balance);
            }
        }
    }

    private void createTransaction(User sender, User receiver, double amount) {
        String transactionId = generateTransactionId();
//        System.out.println(amount + "LLLLLLLLLL");
        Transaction transaction = new Transaction(transactionId, sender, receiver, amount);
        // Process the transaction
        // ...
    }

    private String generateTransactionId() {
//        int transactionNumber = transactionCounter.incrementAndGet();
        return "TXN" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
