package com.transport.data;

import com.transport.instance.RouteInstance;

public class Route {
    private int id;
    private String outset;
    private String inset;
    private int roadsNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutset() {
        return outset;
    }

    public void setOutset(String outset) {
        this.outset = outset;
    }

    public String getInset() {
        return inset;
    }

    public void setInset(String inset) {
        this.inset = inset;
    }

    public int getRoadsNumber() {
        return roadsNumber;
    }

    public void setRoadsNumber(int roadsNumber) {
        this.roadsNumber = roadsNumber;
    }

    public  void createRoute (RouteInstance r){
        this.id = r.getId();
        this.outset = r.getOutset();
        this.inset = r.getInset();
        this.roadsNumber = r.getRoadsNumber();
    }


}
