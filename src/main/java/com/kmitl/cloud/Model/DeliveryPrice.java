package com.kmitl.cloud.Model;

/**
 * Created by snow_ on 02-Mar-17.
 */
public class DeliveryPrice {

    private Coordinate from;
    private Coordinate to;
    private long price;

    public DeliveryPrice(Coordinate from, Coordinate to, long price) {
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public Coordinate getFrom() {
        return from;
    }

    public void setFrom(Coordinate from) {
        this.from = from;
    }

    public Coordinate getTo() {
        return to;
    }

    public void setTo(Coordinate to) {
        this.to = to;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
