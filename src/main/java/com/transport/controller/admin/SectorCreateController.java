package com.transport.controller.admin;

import com.transport.data.Route;
import com.transport.data.Sector;
import com.transport.data.Way;
import com.transport.instance.RouteInstance;
import com.transport.instance.SectorInstance;
import com.transport.instance.WayInstance;
import com.transport.service.SectorService;
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
public class SectorCreateController {

    @Autowired
    @Qualifier(value = "sectorService")
    private SectorService sectorService;

    @Autowired
    @Qualifier(value = "wayService")
    private WayService wayService;

    @Autowired
    @Qualifier(value = "sector")
    private Sector sector;

    @Autowired
    @Qualifier(value = "way")
    private Way way;

    private List<WayInstance> ways;

    @RequestMapping("/sectorCreate")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ModelAndView model = new ModelAndView("sectorCreate");

        ways = wayService.getWays();
        model.addObject("ways", ways);

        if (req.getParameter("id") == null) {
            return model;
        } else {
            sector.setId(Integer.parseInt(req.getParameter("id")));

            String rrid = req.getParameter("ways");
            int rid = Integer.parseInt(rrid);
            sector.setWayId(rid);


            for (WayInstance w:ways) {
                if (w.getId() == rid ){
                    way.setId(w.getId());
                    way.setRouteID(w.getRouteId().getId());
                    way.setSectorNumber(w.getSectorNumbers() + 1);
                    WayInstance wayInstance = new WayInstance(way, w.getRouteId());
                    wayService.updateWay(wayInstance);
                }
            }

            sector.setType(req.getParameter("type"));
            sector.setSpeed(Integer.parseInt(req.getParameter("speed")));
            sector.setTransportCost(Integer.parseInt(req.getParameter("coast")));
            sector.setTimeOnWay(Integer.parseInt(req.getParameter("time")));


            SectorInstance sectorInstance = new SectorInstance(sector);

            sectorService.addSector(sectorInstance);
            model = new ModelAndView("adminInfo");
            model.addObject("info", "Сектор успешно добавлен");
            return model;
        }
    }
}
