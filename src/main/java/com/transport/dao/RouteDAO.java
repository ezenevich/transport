package com.transport.dao;


import com.transport.instance.RouteInstance;

import java.util.List;


public interface RouteDAO {
    List<RouteInstance> getRoutes();

    RouteInstance getRouteByID(int id);

    void addRoute(RouteInstance route);

    void updateRoute(RouteInstance route);

    void deleteRoute(RouteInstance route);
}
