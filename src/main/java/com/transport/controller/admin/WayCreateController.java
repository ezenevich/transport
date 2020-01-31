package com.transport.controller.admin;

import com.transport.data.Route;
import com.transport.data.Way;
import com.transport.instance.RouteInstance;
import com.transport.instance.WayInstance;
import com.transport.service.RouteService;
import com.transport.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class WayCreateController {

    @Autowired
    @Qualifier(value = "routeService")
    private RouteService routeService;

    @Autowired
    @Qualifier(value = "wayService")
    private WayService wayService;

    @Autowired
    @Qualifier(value = "route")
    private Route route;

    @Autowired
    @Qualifier(value = "way")
    private Way way;

    private List<RouteInstance> routes;

    @RequestMapping("/wayCreate")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ModelAndView model = new ModelAndView("wayCreate");

        routes = routeService.getRoutes();
        model.addObject("routes", routes);

        if (req.getParameter("id") == null) {
            return model;
        } else {
            way.setId(Integer.parseInt(req.getParameter("id")));

            String rrid = req.getParameter("route");
            int rid = Integer.parseInt(rrid);
            way.setRouteID(rid);
            way.setSectorNumber(0);

            for (RouteInstance r:routes) {
                if (r.getId() == rid ){
                    route.createRoute(r);
                }
            }
            route.setRoadsNumber(route.getRoadsNumber() + 1);

            WayInstance wayInstance = new WayInstance(way, routeService.createNewRoute(route));

            wayService.addWay(wayInstance);
            routeService.updateRoute(routeService.createNewRoute(route));
            model = new ModelAndView("adminInfo");
            model.addObject("info", "Трасса успешно добавлена");
            return model;
        }
    }
}
