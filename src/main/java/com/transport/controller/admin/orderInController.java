package com.transport.controller.admin;

import com.transport.instance.OrderInstance;
import com.transport.instance.RouteInstance;
import com.transport.service.OrderService;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class orderInController {


    @Autowired
    @Qualifier(value = "orderService")
    private OrderService orderService;


    private List<OrderInstance> orders;


    @RequestMapping("/orderIn")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ModelAndView model = new ModelAndView("orderIn");

        orders = orderService.getFullOrders();
        model.addObject("routes", orders);


        if (req.getParameter("but") == null) {
            return model;
        } else {

            OrderInstance orderInstance = new OrderInstance();
            int in = Integer.parseInt(req.getParameter("in"));
            for (OrderInstance o : orders) {
                if(o.getId() == in){
                    o.setDelivery("доставлен");
                    orderService.updateOrder(o);
                    orderInstance = o;
                }

            }

            model = new ModelAndView("adminInfo");
            model.addObject("info", "Товар принят.");

            return model;
        }
    }
}
