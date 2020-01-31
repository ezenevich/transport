package com.transport.controller.admin;

import com.transport.data.Route;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RouteCreateController {

    @Autowired
    @Qualifier(value = "routeService")
    private RouteService routeService;

    @Autowired
    @Qualifier(value = "route")
    private Route route;

    @RequestMapping("/routeCreate")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("outset") == null) {
            ModelAndView model = new ModelAndView("routeCreate");
            return model;
        } else {
            route.setId(Integer.parseInt(req.getParameter("id")));
            route.setOutset(req.getParameter("outset"));
            route.setInset(req.getParameter("inset"));
            route.setRoadsNumber(0);

            routeService.addRoute(routeService.createNewRoute(route));
            ModelAndView model = new ModelAndView("adminInfo");
            model.addObject("info", "Маршрут успешно добавлен");
            return model;
        }
    }
}
