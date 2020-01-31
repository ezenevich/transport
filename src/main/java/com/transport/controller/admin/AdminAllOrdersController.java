package com.transport.controller.admin;

import com.transport.instance.OrderInstance;
import com.transport.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminAllOrdersController {

    @Autowired
    @Qualifier(value = "orderService")
    private OrderService orderService;

    private List<OrderInstance> orders;

    @RequestMapping("/allOrders")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ModelAndView model = new ModelAndView("allOrders");

        orders = orderService.getOrders();
        if(orders.isEmpty()){
            return model;
        } else {
            model.addObject("orders", orders);
            return model;
        }
    }
}
