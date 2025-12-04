package com.gorakh.lldrunner.fooddeliveryservice;

public class DeliveryAgent {
    private final String  id;
    private final String name;
    private final String phoneNumber;
    private  DeliveryAgentAvailabilityStatus status;

    public DeliveryAgent(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status =   DeliveryAgentAvailabilityStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public void setStatus(DeliveryAgentAvailabilityStatus status) {
        this.status = status;
    }

    public DeliveryAgentAvailabilityStatus getStatus() {
        return status;
    }



}
