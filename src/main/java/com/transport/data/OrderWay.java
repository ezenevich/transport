package com.transport.data;

import com.transport.instance.SectorInstance;

import java.util.ArrayList;
import java.util.List;

public class OrderWay {
    int id;
    int wayId;
    String name;
    String userName;
    String type;
    int totalCoast;
    int totalTime;
    List<SectorInstance> sectors;
    int weight;
    String delivery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalCoast() {
        return totalCoast;
    }

    public void setTotalCoast(int totalCoast) {
        this.totalCoast = totalCoast;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public List<SectorInstance> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorInstance> sectors) {
        this.sectors = sectors;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
