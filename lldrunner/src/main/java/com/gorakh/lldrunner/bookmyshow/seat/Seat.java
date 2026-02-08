package com.gorakh.lldrunner.bookmyshow.seat;

public class Seat {
    private final String id;
    private final int row;
    private final int column;
    private final SeatType type;
    private SeatStatus status;
    private double price;

    public Seat(String id, int row, int column, SeatType type) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
        this.price = type == SeatType.NORMAL ? 200 : 300;
    }

    public String getId() {
        return id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }
}
