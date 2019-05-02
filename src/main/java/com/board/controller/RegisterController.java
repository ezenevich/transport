
package com.board.controller;

import javax.servlet.http.HttpServletRequest;

import com.board.service.UserService;
import com.board.user.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest req) {
        String login = req.getParameter("login");
        if (login == null) {
            ModelAndView model = new ModelAndView("reg");
            return model;
        } else {
            ModelAndView model = new ModelAndView("info");
            if (userService.getUserByLogin(login) == null) {
                userService.addUser(userConverter.userToRegister(
                        login,
                        req.getParameter("pass"),
                        req.getParameter("phone")));
                model.addObject("info", "Регистрация прошла успешна!!!");
            } else {
                model.addObject("info", "Пользоватил с таким именем уже есть.");
            }
            return model;
        }
    }
}
