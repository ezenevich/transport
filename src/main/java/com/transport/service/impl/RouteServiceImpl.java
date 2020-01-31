package com.transport.service.impl;

import com.transport.dao.RouteDAO;
import com.transport.data.Route;
import com.transport.instance.RouteInstance;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("routeService")
public class RouteServiceImpl implements RouteService {


    private RouteDAO rdao;

    @Autowired
    public void setRouteService(RouteDAO rdao) {
        this.rdao = rdao;
    }

    public List<RouteInstance> getRoutes() {
        return rdao.getRoutes();
    }

    public RouteInstance getRouteByID (int id) {
        return rdao.getRouteByID(id);
    }

    public void addRoute(RouteInstance r) {
        rdao.addRoute(r);
    }

    public void updateRoute(RouteInstance r) {
        rdao.updateRoute(r);
    }

    public void deleteRoute(RouteInstance r) {
        rdao.deleteRoute(r);
    }

    @Override
    public RouteInstance createNewRoute(Route route) {
        return new RouteInstance(route.getId(), route.getOutset(), route.getInset(), route.getRoadsNumber());
    }
}
