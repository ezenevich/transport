package com.transport.service;

import com.transport.data.Route;
import com.transport.instance.RouteInstance;
import java.util.List;


public interface RouteService {

    List<RouteInstance> getRoutes();

    RouteInstance getRouteByID(int id);

    void addRoute(RouteInstance route);

    void updateRoute(RouteInstance route);

    void deleteRoute(RouteInstance route);

    RouteInstance createNewRoute(Route route);
}
