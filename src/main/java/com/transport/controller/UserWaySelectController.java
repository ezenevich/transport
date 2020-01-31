package com.transport.controller;

import com.transport.data.OrderWay;
import com.transport.data.User;
import com.transport.instance.OrderInstance;
import com.transport.instance.SectorInstance;
import com.transport.instance.UserInstance;
import com.transport.instance.WayInstance;
import com.transport.service.OrderService;
import com.transport.service.SectorService;
import com.transport.service.UserService;
import com.transport.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserWaySelectController {

    @Autowired
    @Qualifier(value = "wayService")
    private WayService wayService;

    @Autowired
    @Qualifier(value = "sectorService")
    private SectorService sectorService;

    @Autowired
    @Qualifier(value = "orderService")
    private OrderService orderService;

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;


    private List<WayInstance> ways;
    private List<OrderWay> orderWays;
    private List<SectorInstance> sectors;

    @RequestMapping("/userWaySelection")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ModelAndView model = new ModelAndView("userWaySelection");

        List<WayInstance> allWays = wayService.getWays();
        int routeId = (Integer) session.getAttribute("routeId");
        String name = (String) session.getAttribute("name");
        User user = (User) session.getAttribute("user");

        ways = new ArrayList<WayInstance>();
        for (WayInstance w : allWays) {
            if (w.getRouteId().getId() == routeId) {
                ways.add(w);
            }
        }

        orderWays = new ArrayList<OrderWay>();
        for (WayInstance w : ways) {
            sectors = sectorService.getSectorsByWay(w.getId());
            String type="";
            int coast = 0;
            int time = 0;
            for(SectorInstance s : sectors){
                type+= s.getType() + " ";
                coast+= s.getTransportCost();
                time+= s.getTimeOnWay();
            }
            OrderWay o = new OrderWay();
            o.setId(w.getId() + user.getId() + 37);
            o.setWayId(w.getId());
            o.setName(name);
            o.setUserName(user.getLogin());
            o.setType(type);
            o.setTotalCoast(coast);
            o.setTotalTime(time);
            o.setSectors(sectors);
            orderWays.add(o);
        }

        model.addObject("name", name);
        model.addObject("orderWays", orderWays);



        if (req.getParameter("but2") == null) {
            return model;
        } else {
            OrderInstance orderInstance;
            String id = req.getParameter("order");
            int oid = Integer.parseInt(id);

            for (OrderWay order : orderWays) {
                if (order.getId() == oid) {
                    int weight = Integer.parseInt(req.getParameter("weight"));
                    orderInstance = new OrderInstance(order.getId(), order.getWayId(), order.getName(), order.getType(), order.getTotalTime(), order.getTotalCoast(), order.getUserName(), weight, "загружается");
                    orderService.addOrder(orderInstance);
                    user.setOrderId(orderInstance.getId());
                }
            }



            UserInstance userInstance = new UserInstance(user.getId(), user.getLogin(), user.getPassword(), user.getOrderId());
            userService.updateUser(userInstance);


            model = new ModelAndView("info");
            model.addObject("info", "Заказ успешно оформлен");
            return model;
        }

    }
}
