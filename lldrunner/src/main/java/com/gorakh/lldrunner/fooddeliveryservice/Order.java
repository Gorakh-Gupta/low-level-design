package com.gorakh.lldrunner.fooddeliveryservice;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String  id;
    private final Customer customer;
    private final Restaurant restaurant;

    private final List<OrderItem> items;
    private  DeliveryAgent agent;
    private OrderStatus status;

    public Order(String id, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    void addItem(OrderItem item){
        items.add(item);
    }

    public String getId() {
        return id;
    }

    public void setAgent(DeliveryAgent agent) {
        this.agent = agent;
    }

    void removeItem(OrderItem item){
        items.remove(item);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
