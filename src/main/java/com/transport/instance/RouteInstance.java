package com.transport.instance;

import javax.persistence.*;

@Entity
@Table(name = "route", schema = "transport")
public class RouteInstance {
    private int id;
    private String outset;
    private String inset;
    private int roadsNumber;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "outset", nullable = false, length = 30)
    public String getOutset() {
        return outset;
    }

    public void setOutset(String outset) {
        this.outset = outset;
    }

    @Basic
    @Column(name = "inset", nullable = false, length = 30)
    public String getInset() {
        return inset;
    }

    public void setInset(String inset) {
        this.inset = inset;
    }

    @Basic
    @Column(name = "roadsNumber", nullable = false)
    public int getRoadsNumber() {
        return roadsNumber;
    }

    public void setRoadsNumber(int roadsNumber) {
        this.roadsNumber = roadsNumber;
    }

    public RouteInstance(int id, String outset, String inset, int roadsNumber) {
        this.id = id;
        this.outset = outset;
        this.inset = inset;
        this.roadsNumber = roadsNumber;
    }

    public RouteInstance() {}
}
