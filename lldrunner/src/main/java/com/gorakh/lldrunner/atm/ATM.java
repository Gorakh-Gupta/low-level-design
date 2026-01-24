package com.gorakh.lldrunner.atm;

public class ATM {
    private final BankService bankService;
    private final CashDispenser cashDispenser;

    public ATM(BankService bankingService, CashDispenser cashDispenser) {
        this.bankService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateUser(Card card) {
//        return ;
    }

    public double checkBalance(String accountNumber) {
        Account account = bankService.getAccounts(accountNumber);
        return account.getBalance();
    }

    public void withdrawCash(String accountNumber, double amount) {
        Account account = bankService.getAccounts(accountNumber);
        if(account.getBalance() >= amount){
            account.debit(amount);
        }else{
            System.out.println("Less Amount Available");
        }
    }

    public void depositCash(String accountNumber, double amount) {
        Account account = bankService.getAccounts(accountNumber);
        account.credit(amount);
    }
}
