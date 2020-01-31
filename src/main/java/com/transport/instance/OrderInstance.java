package com.transport.instance;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "transport")
public class OrderInstance {
    private int id;
    private int wayId;
    private String nameRoute;
    private String type;
    private int totalTime;
    private int totalCoast;
    private String userName;
    private int weight;
    private String delivery;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wayId", nullable = false)
    public int getWayId() {
        return wayId;
    }

    public void setWayId(int wayId) {
        this.wayId = wayId;
    }

    @Basic
    @Column(name = "nameRoute", nullable = true, length = 100)
    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "totalTime", nullable = false)
    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    @Basic
    @Column(name = "totalCoast", nullable = false)
    public int getTotalCoast() {
        return totalCoast;
    }
    public void setTotalCoast(int totalCoast) {
        this.totalCoast = totalCoast;
    }

    @Basic
    @Column(name = "userName", nullable = false, length = 35)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Basic
    @Column(name = "weight", nullable = true)
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Basic
    @Column(name = "delivery", nullable = true, length = 15)
    public String getDelivery() {
        return delivery;
    }
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInstance that = (OrderInstance) o;
        return id == that.id &&
                wayId == that.wayId &&
                totalTime == that.totalTime &&
                totalCoast == that.totalCoast &&
                Objects.equals(nameRoute, that.nameRoute) &&
                Objects.equals(type, that.type) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wayId, nameRoute, type, totalTime, totalCoast, userName);
    }

    public OrderInstance() {
    }

    public OrderInstance(int id, int wayId, String nameRoute, String type, int totalTime, int totalCoast, String userName, int weight, String delivery) {
        this.id = id;
        this.wayId = wayId;
        this.nameRoute = nameRoute;
        this.type = type;
        this.totalTime = totalTime;
        this.totalCoast = totalCoast;
        this.userName = userName;
        this.weight = weight;
        this.delivery = delivery;
    }
}
