package com.transport.dao;

import com.transport.instance.WayInstance;
import java.util.List;


public interface WayDAO {
    List<WayInstance> getWays();

    List<WayInstance> getWaysByRoute(int routeId);

    WayInstance getWayByID(int id);

    void addWay(WayInstance way);

    void updateWay(WayInstance way);

    void deleteWay(WayInstance way);
}
