package com.transport.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AdminMainController {

    @RequestMapping("/adminMain")
    public ModelAndView main(HttpServletRequest req) {

        ModelAndView model = new ModelAndView("adminMain");
        return model;
    }
}
