package com.gorakh.lldrunner.vendingmachine;

public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("ss");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("SS");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("ss");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("ss");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }

        vendingMachine.resetPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
