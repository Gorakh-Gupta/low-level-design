package com.gorakh.lldrunner.fooddeliveryservice;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
    private static FoodDeliveryService instance;

    private final Map<String , Restaurant>restaurants;
    private final Map<String, Customer> customers;
    private final Map<String ,DeliveryAgent>agents;
    private final Map<String ,Order>orders;

    FoodDeliveryService(){
        restaurants=new ConcurrentHashMap<>();
        agents = new ConcurrentHashMap<>();
        customers = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
    }

    public static synchronized FoodDeliveryService getInstance(){
        if(instance == null){
            instance = new FoodDeliveryService();
        }
        return instance;
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(),restaurant);
    }

    public void registerDeliveryAgent(DeliveryAgent agent) {
        agents.put(agent.getId(), agent);
    }

    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
            System.out.println("Order status :" + order.getStatus());
            notifyCustomer(order);
            if (status == OrderStatus.CONFIRMED) {
                assignDeliveryAgent(order);
            }
        }
    }

    private DeliveryAgent assignDeliveryAgent(Order order){
        for(DeliveryAgent agent:agents.values()){
            if(agent.getStatus() == DeliveryAgentAvailabilityStatus.AVAILABLE){
                order.setAgent(agent);
                order.setStatus(OrderStatus.PREPARING);
                notifyCustomer(order);
                return agent;
            }
        }
        return null;
    }

    private void notifyCustomer(Order order) {
        System.out.println("Order is : " + order.getStatus());
    }

    public Order placeOrder(String customerId, String restaurantId, List<OrderItem> items) {
        Customer customer = customers.get(customerId);
        Restaurant restaurant = restaurants.get(restaurantId);
        if (customer != null && restaurant != null) {
            Order order = new Order(generateOrderId(), customer, restaurant);
            for (OrderItem item : items) {
                order.addItem(item);
            }
            orders.put(order.getId(), order);
            notifyRestaurant(order);
            System.out.println("Order placed: " + order.getId());
            return order;
        }
        return null;
    }

    private void notifyRestaurant(Order order) {
        updateOrderStatus(order.getId(),OrderStatus.CONFIRMED);
    }

    private String generateOrderId() {
        // Generate a unique order ID using UUID
        return "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void cancelOrder(String order_id) {
        for(Order order : orders.values()){
            if(order_id.equals(order.getId())){
                order.setStatus(OrderStatus.CANCELLED);
                System.out.println("Order with id has been cancelled: " + order_id);
                return;
            }
        }

        System.out.println("Order not found");
    }
}
