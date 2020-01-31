package com.transport.data;

public class Sector {
    private int id;
    private int wayId;
    private String type;
    private int speed;
    private int transportCost;
    private int timeOnWay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    public int getTimeOnWay() {
        return timeOnWay;
    }

    public void setTimeOnWay(int timeOnWay) {
        this.timeOnWay = timeOnWay;
    }

    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }
}
