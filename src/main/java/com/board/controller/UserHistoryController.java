
package com.board.controller;

import com.board.instance.Item;
import com.board.item.ItemForOwner;
import com.board.service.FavoriteService;
import com.board.service.HistoryService;
import com.board.user.UserForSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserHistoryController {

    @Autowired
    @Qualifier(value = "histServ")
    private HistoryService histService;

    private UserForSession userForSession = null;
    private List<ItemForOwner> listUpdate = null;
    private List<Item> listItems = null;

    @RequestMapping(value = "/userHistory", method = RequestMethod.GET)
    public ModelAndView userHistory(HttpServletRequest req) {


        ModelAndView model = new ModelAndView("userHistory");
        userForSession = (UserForSession) req.getSession().getAttribute("user");
        listItems = (List<Item>) req.getSession().getAttribute("items");
        listUpdate = histService.crudHist(userForSession, req.getParameter("id"), listItems);
        model.addObject("user", userForSession);
        if (listUpdate != null) {
            model.addObject("items", listUpdate);
        }
        return model;
    }

}
