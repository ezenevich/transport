package com.transport.service;


import com.transport.instance.OrderInstance;
import java.util.List;


public interface OrderService {

    List<OrderInstance> getOrders();
    List<OrderInstance> getFreeOrders();
    List<OrderInstance> getFullOrders();

    OrderInstance getOrderByID(int id);

    void addOrder(OrderInstance s);

    void updateOrder(OrderInstance s);

    void deleteOrder(OrderInstance s);
}
