package com.transport.service.impl;

import com.transport.dao.OrderDAO;
import com.transport.dao.RouteDAO;
import com.transport.data.Route;
import com.transport.instance.OrderInstance;
import com.transport.instance.RouteInstance;
import com.transport.service.OrderService;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("orderService")
public class OrderServiceImpl implements OrderService {


    private OrderDAO odao;

    @Autowired
    public void setOrderService(OrderDAO odao) {
        this.odao = odao;
    }

    public List<OrderInstance> getOrders() {
        return odao.getOrders();
    }
    public List<OrderInstance> getFreeOrders() {
        return odao.getFreeOrders();
    }
    public List<OrderInstance> getFullOrders() {
        return odao.getFullOrders();
    }

    public OrderInstance getOrderByID (int id) {
        return odao.getOrderByID(id);
    }

    public void addOrder(OrderInstance r) {
        odao.addOrder(r);
    }

    public void updateOrder(OrderInstance r) {
        odao.updateOrder(r);
    }

    public void deleteOrder(OrderInstance r) {
        odao.deleteOrder(r);
    }

}
