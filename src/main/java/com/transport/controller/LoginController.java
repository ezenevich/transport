package com.transport.controller;

import com.transport.data.User;
import com.transport.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    @Qualifier(value = "user")
    private User user;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest req) {

        if (req.getParameter("login") == null) {
            ModelAndView model = new ModelAndView("login");
            return model;
        } else {
            ModelAndView model = new ModelAndView("info");
            String login = req.getParameter("login");
            String pass = req.getParameter("pass");

            User u = null;

            try {
                u = user.getUser(userService.getUserByLogin(login));
                System.out.println(u.getLogin());
            } catch (NullPointerException e) {
                model.addObject("info", "Неверное имя пользователя");
            }
            if (u == null) {
                model.addObject("info", "Неверное имя пользователя");
            } else {
                /**
                 If login taken from db correct, check password and send User to session, log in.
                 */
                if (u.getPassword().equals(pass)) {
                    HttpSession s = req.getSession();
                    s.setAttribute("user", u);
                    model.addObject("info", "Авторизация прошла успешно");
                } else {
                    model.addObject("info", "Неверный пароль");
                }
            }
            return model;
        }
    }
}
