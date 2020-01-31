package com.transport.controller.admin;

import com.transport.instance.OrderInstance;

import java.util.Comparator;

public class MyComparator implements Comparator<OrderInstance> {

    @Override
    public int compare(OrderInstance o1, OrderInstance o2) {
        return Integer.compare(o2.getTotalCoast(), o1.getTotalCoast());
    }
}
