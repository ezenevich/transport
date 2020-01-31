package com.transport.service;

import com.transport.data.Way;
import com.transport.instance.RouteInstance;
import com.transport.instance.WayInstance;

import java.util.List;


public interface WayService {

    List<WayInstance> getWays();

    List<WayInstance> getWaysByRoute(int routeId);

    WayInstance getWayByID(int id);

    void addWay(WayInstance way);

    void updateWay(WayInstance way);

    void deleteWay(WayInstance way);

}
