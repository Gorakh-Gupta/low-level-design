package com.gorakh.lldrunner.stockbrokeragesystem;

import java.util.Map;

public class BuyOrder extends Order{

    public BuyOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }
    @Override
    public void execute() {
        double totalCost = quantity * price;
//        System.out.println(totalCost+" lll" + account.getBalance());
        if (account.getBalance() >= totalCost) {
            account.withdraw(totalCost);
            // Update portfolio and perform necessary actions
            Portfolio portfolio = account.getPortfolio();
            portfolio.addStock(stock,quantity);
            status = OrderStatus.EXECUTED;
        } else {
            status = OrderStatus.REJECTED;
            throw new InsufficientFundsException("Insufficient funds to execute the buy order.");
        }

    }
}
