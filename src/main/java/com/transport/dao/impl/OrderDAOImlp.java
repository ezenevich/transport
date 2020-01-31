package com.transport.dao.impl;

import com.transport.dao.OrderDAO;
import com.transport.dao.SectorDAO;
import com.transport.instance.OrderInstance;
import com.transport.instance.SectorInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class OrderDAOImlp implements OrderDAO {

    private static final Logger logger = Logger.getLogger(OrderDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;


    public List<OrderInstance> getOrders() {
        logger.info("Get all Order from db");
        return template.loadAll(OrderInstance.class);
    }

    public List<OrderInstance> getFreeOrders() {
        logger.info("Order with free status was getted from db");
        List<OrderInstance> r = (List<OrderInstance>) template.find("from OrderInstance a where a.delivery = ?", "загружается");
        if ( r.isEmpty() ) {
            return null;
        }
        return r;
    }

    public List<OrderInstance> getFullOrders() {
        logger.info("Order with free status was getted from db");
        List<OrderInstance> r = (List<OrderInstance>) template.find("from OrderInstance a where a.delivery = ?", "доставляется");
        if ( r.isEmpty() ) {
            return null;
        }
        return r;
    }



    public OrderInstance getOrderByID(int id) {
        logger.info("Order with id " + id + " was getted from db");
        List<OrderInstance> r = (List<OrderInstance>) template.find("from OrderInstance a where a.id = ?", id);
        if ( r.isEmpty() ) {
            return null;
        }
        return (OrderInstance)r.get(0);
    }



    public void addOrder(OrderInstance i) {
        template.save(i);
        logger.info("Add new Order with id " + i.getId());
    }

    public void updateOrder(OrderInstance i) {
        template.update(i);
        logger.info("Update Order with id " + i.getId());
    }

    public void deleteOrder(OrderInstance i){
        template.delete(i);
        logger.info("Delete Order with id " + i.getId());
    }


}
