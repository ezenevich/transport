package com.transport.controller.admin;

import com.transport.data.OrderWay;
import com.transport.data.Route;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
public class orderOutController {

    @Autowired
    @Qualifier(value = "routeService")
    private RouteService routeService;

    @Autowired
    @Qualifier(value = "orderService")
    private OrderService orderService;


    private int opasiti = 1000;
    private String out;

    private List<RouteInstance> routes;
    private List<OrderInstance> orders;
    private List<OrderInstance> orders2;
    private ArrayList<OrderInstance> ord;
    private ArrayList<OrderInstance> ordOut;



    @RequestMapping("/orderOut")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ModelAndView model = new ModelAndView("orderOut");

        routes = routeService.getRoutes();
        model.addObject("routes", routes);

        //////////////////////////////////////////////////////////////////////////////////////////

        if (req.getParameter("but") == null) {
            return model;
        } else {
            out = req.getParameter("route");
            orders = orderService.getFreeOrders();
            orders2 = orderService.getFreeOrders();

            //присвоить заказам только имя отправления
            for (OrderInstance o : orders) {
                String str = o.getNameRoute().substring(0, o.getNameRoute().indexOf("-"));
                o.setNameRoute(str);
            }

            //взять заказы из выбранного города
            ord = new ArrayList<OrderInstance>();
            for (OrderInstance oo : orders) {
                if(oo.getNameRoute().equals(out)) {
                    ord.add(oo);
                }
            }

            //найти удельную стоимость каждого заказа
            for (OrderInstance o : ord) {
                o.setTotalCoast((Integer)o.getTotalCoast()/o.getWeight());
            }

            //отсортировать по убыванию стоимость удельной
            ord.sort(new MyComparator());

            //брать в рюкзак самый дорогой товар
            ordOut = new ArrayList<OrderInstance>();
            for (OrderInstance o : ord) {
                if(opasiti - o.getWeight() >= 0){
                    opasiti -= o.getWeight();
                    ordOut.add(o);
                    System.out.println(o.getTotalCoast());
                }
            }

            //вернуть норм цену и массу загруженным заказам
            //изменить статус загруженного товара на доставляется
            for (OrderInstance o : ordOut) {
                for (OrderInstance oo : orders2) {
                    if(o.getId() == oo.getId()){
                        o.setTotalCoast(oo.getTotalCoast());
                        o.setNameRoute(oo.getNameRoute());
                        o.setDelivery("доставляется");
                    }
                }
            }

            //обнавить заказы в бд
            for (OrderInstance o : ordOut) {
                orderService.updateOrder(o);
            }

/////////////////////////////////////////////////////////////////////////////////////////////////

            model = new ModelAndView("adminOrderInfo");
            model.addObject("info", "Транспорт загружен следующими заказами:");
            model.addObject("info2", ordOut);
            return model;
        }
    }
}
