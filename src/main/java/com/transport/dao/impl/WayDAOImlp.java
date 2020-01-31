package com.transport.dao.impl;

import com.transport.dao.WayDAO;
import com.transport.instance.WayInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class WayDAOImlp implements WayDAO {

    private static final Logger logger = Logger.getLogger(WayDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;


    public List<WayInstance> getWays() {
        logger.info("Get all ways from db");
        return template.loadAll(WayInstance.class);
    }

    public List<WayInstance> getWaysByRoute (int routeId) {
        logger.info("Ways with route id " + routeId + " was getted from db");
        List<WayInstance> ways = (List<WayInstance>) template.find("from WayInstance a where a.routeId.id = ?", routeId);
        if ( ways.isEmpty() ) {
            return null;
        }
        return ways;
    }

    public WayInstance getWayByID(int id) {
        logger.info("Way with id " + id + " was getted from db");
        List<WayInstance> r = (List<WayInstance>) template.find("from WayInstance a where a.id = ?", id);
        if ( r.isEmpty() ) {
            return null;
        }
        return (WayInstance)r.get(0);
    }

    public void addWay(WayInstance way) {
        template.save(way);
        logger.info("Add new way with id " + way.getId());
    }

    public void updateWay(WayInstance way) {
        template.update(way);
        logger.info("Update way with id " + way.getId());
    }

    public void deleteWay(WayInstance way){
        template.delete(way);
        logger.info("Delete way with id " + way.getId());
    }


}
