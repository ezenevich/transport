package com.transport.instance;

import com.transport.data.Way;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "way", schema = "transport")
public class WayInstance {
    private int id;
    private int sectorNumbers;
    private RouteInstance routeId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sectorsNumber", nullable = false)
    public int getSectorNumbers() {
        return sectorNumbers;
    }

    public void setSectorNumbers(int sectorNumbers) {
        this.sectorNumbers = sectorNumbers;
    }

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "ID", nullable = false)
    public RouteInstance getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteInstance routeId) {
        this.routeId = routeId;
    }

    public WayInstance(Way way, RouteInstance route){
        this.id = way.getId();
        this.sectorNumbers = way.getSectorNumber();
        this.routeId = route;
    }

    public WayInstance(){
    }
}
