package com.transport.dao.impl;

import com.transport.dao.RouteDAO;
import com.transport.instance.RouteInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class RouteDAOImlp implements RouteDAO {

    private static final Logger logger = Logger.getLogger(RouteDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;


    public List<RouteInstance> getRoutes() {
        logger.info("Get all routes from db");
        return template.loadAll(RouteInstance.class);
    }

    public RouteInstance getRouteByID(int id) {
        logger.info("Route with id " + id + " was getted from db");
        List<RouteInstance> r = (List<RouteInstance>) template.find("from RouteInstance a where a.id = ?", id);
        if ( r.isEmpty() ) {
            return null;
        }
        return (RouteInstance)r.get(0);
    }

    public void addRoute(RouteInstance route) {
        template.save(route);
        logger.info("Add new route with id " + route.getId());
    }

    public void updateRoute(RouteInstance route) {
        template.update(route);
        logger.info("Update route with id " + route.getId());
    }

    public void deleteRoute(RouteInstance route){
        template.delete(route);
        logger.info("Delete route with id " + route.getId());
    }


}
