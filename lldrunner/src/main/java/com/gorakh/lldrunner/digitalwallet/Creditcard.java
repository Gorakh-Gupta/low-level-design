package com.gorakh.lldrunner.digitalwallet;
public class Creditcard extends PaymentMethod {
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;

    public Creditcard(String id, User user, String cardNumber, String expirationDate, String cvv) {
        super(id, user);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
