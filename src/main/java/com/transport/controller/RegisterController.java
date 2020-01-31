
package com.transport.controller;

import javax.servlet.http.HttpServletRequest;

import com.transport.instance.UserInstance;
import com.transport.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {


    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @RequestMapping("/reg")
    public ModelAndView register(HttpServletRequest req) {
        String login = req.getParameter("login");
        if (login == null) {
            ModelAndView model = new ModelAndView("reg");
            return model;
        } else {
            ModelAndView model = new ModelAndView("infoReg");
            if (userService.getUserByLogin(login) == null) {
                UserInstance userInstance = new UserInstance(login, req.getParameter("pass"), 0);
                userService.addUser(userInstance);
                model.addObject("info", "Регистрация прошла успешна!!!");
            } else {
                model.addObject("info", "Пользоватил с таким именем уже есть.");
            }
            return model;
        }
    }
}
