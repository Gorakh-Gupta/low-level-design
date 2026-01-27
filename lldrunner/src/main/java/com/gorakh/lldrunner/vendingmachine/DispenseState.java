package com.gorakh.lldrunner.vendingmachine;

public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("ss");

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("ss");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("ss");
    }


    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState()); // Change the state to ReturnChangeState
    }

    @Override
    public void returnChange() {
        System.out.println("ss");
    }
}
