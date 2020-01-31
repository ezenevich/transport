package com.transport.instance;

import com.transport.data.Sector;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sector", schema = "transport")
public class SectorInstance {
    private int id;
    private int wayId;
    private String type;
    private int speed;
    private int transportCost;
    private int timeOnWay;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wayID", nullable = false)
    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "speed", nullable = false)
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "transportCost", nullable = false)
    public int getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    @Basic
    @Column(name = "timeOnWay", nullable = false)
    public int getTimeOnWay() {
        return timeOnWay;
    }

    public void setTimeOnWay(int timeOnWay) {
        this.timeOnWay = timeOnWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorInstance that = (SectorInstance) o;
        return id == that.id &&
                wayId == that.wayId &&
                speed == that.speed &&
                transportCost == that.transportCost &&
                timeOnWay == that.timeOnWay &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wayId, type, speed, transportCost, timeOnWay);
    }


    public SectorInstance(Sector s){
        this.id = s.getId();
        this.wayId = s.getWayId();
        this.type = s.getType();
        this.speed = s.getSpeed();
        this.transportCost = s.getTransportCost();
        this.timeOnWay = s.getTimeOnWay();
    }

    public SectorInstance(){}
}
