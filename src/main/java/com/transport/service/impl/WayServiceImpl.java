package com.transport.service.impl;

import com.transport.dao.WayDAO;
import com.transport.data.Route;
import com.transport.data.Way;
import com.transport.instance.RouteInstance;
import com.transport.instance.WayInstance;
import com.transport.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("wayService")
public class WayServiceImpl implements WayService {


    private WayDAO wdao;

    @Autowired
    public void setWayService(WayDAO wdao) {
        this.wdao = wdao;
    }

    public List<WayInstance> getWays() {
        return wdao.getWays();
    }

    public List<WayInstance> getWaysByRoute(int routeId) { return wdao.getWaysByRoute(routeId); }

    public WayInstance getWayByID (int id) {
        return wdao.getWayByID(id);
    }

    public void addWay(WayInstance instance) {
        wdao.addWay(instance);
    }

    public void updateWay(WayInstance instance) {
        wdao.updateWay(instance);
    }

    public void deleteWay(WayInstance instance) {
        wdao.deleteWay(instance);
    }

}
