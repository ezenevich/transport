package com.transport.controller;

import com.transport.data.Route;
import com.transport.instance.RouteInstance;
import com.transport.service.RouteService;
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
public class UserRouteSelectController {

    @Autowired
    @Qualifier(value = "routeService")
    private RouteService routeService;

    @Autowired
    @Qualifier(value = "route")
    private Route route;


    private List<RouteInstance> routes;

    @RequestMapping("/userRouteSelection")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ModelAndView model = new ModelAndView("userRouteSelection");

        routes = routeService.getRoutes();
        model.addObject("routes", routes);

        if (req.getParameter("but") == null) {
            return model;
        } else {
            String rrid = req.getParameter("route");
            int rid = Integer.parseInt(rrid);

            for (RouteInstance r : routes) {
                if (r.getId() == rid) {
                    route.createRoute(r);
                }
            }

            String name = route.getOutset() + "-" + route.getInset();


            HttpSession session = req.getSession();
            session.setAttribute("routeId", route.getId());
            session.setAttribute("name", name);
            model = new ModelAndView("orderInfo");
            model.addObject("info", "Маршрут выбран");
            return model;
        }
    }
}
