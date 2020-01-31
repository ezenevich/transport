package com.transport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.data.User;
import com.transport.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    @Qualifier(value = "orderService")
    private OrderService orderService;



    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        ModelAndView model = new ModelAndView("main");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(user.getOrderId() == 0){
            return model;
        } else {
            model.addObject("order", orderService.getOrderByID(user.getOrderId()));
            return model;
        }
    }
}
