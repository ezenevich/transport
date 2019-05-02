
package com.board.controller;

import com.board.instance.Item;
import com.board.item.ItemConverter;
import com.board.service.FavoriteService;
import com.board.service.MainService;
import com.board.service.UserService;
import com.board.user.UserConverter;
import com.board.user.UserForOwner;
import com.board.user.UserForSession;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SingleItemController {

    @Autowired
    private MainService mainService;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "favServ")
    private FavoriteService favoriteService;

    @RequestMapping("/item")
    public ModelAndView singleItem(HttpServletRequest req) {

        /*
         *  Page for a detailed product description.
         *  Get a list of items from a session, select by id and return to page.
         *  Get owner by login and return to page.
         *  Test if user Log In, for make available button 'Add to favorites'
         */
        ModelAndView model = new ModelAndView("singleItem");
        List<Item> items = (List<Item>) req.getSession().getAttribute("items");
        String id = req.getParameter("id");
        String owner = req.getParameter("owner");
        UserForOwner userForOwner = userConverter.userForOwner(userService.getUserByLogin(owner));
        model.addObject("isLogin", mainService.isLogin((UserForSession) req.getSession().getAttribute("user")));
        model.addObject("items", itemConverter.convertItemForSingle(itemConverter.getItemById(id, items)));
        model.addObject("owner", userForOwner);

        UserForSession u = (UserForSession) req.getSession().getAttribute("user");

        model.addObject("userData", u);
        
        favoriteService.updateFavorites(u, id);

        return model;
    }
}
