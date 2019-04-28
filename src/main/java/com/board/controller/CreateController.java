package com.board.controller;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.service.ItemService;
import com.board.user.UserForSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController {

    @Autowired
    @Qualifier(value = "itemServ")
    private ItemService itemService;

    @RequestMapping("/create")
    public ModelAndView main(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        /**
         *  Create new Item in callboard.
         */
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("name") == null) {
            ModelAndView model = new ModelAndView("create");
            return model;
        } else {
            System.out.println(req.getParameter("name") + "   lololololol");
            itemService.addItem(itemService.createItem(
                    req.getParameter("name")
                    , Integer.parseInt(req.getParameter("price"))
                    , req.getParameter("about")
                    , req.getParameter("img")
                    , req.getParameter("smallimg")
                    , req.getParameter("category")
                    , ((UserForSession) req.getSession().getAttribute("user")).getLogin())
            );
            resp.sendRedirect("/kursovoi_war/main");
            return null;
        }
    }
}
