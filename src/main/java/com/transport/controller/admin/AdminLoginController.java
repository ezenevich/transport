package com.transport.controller.admin;


import com.transport.service.AdminService;
import com.transport.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class AdminLoginController {

    @Autowired
    @Qualifier(value = "adminService")
    private AdminService adminService;

    @Autowired
    @Qualifier(value = "admin")
    private Admin admin;

    @RequestMapping("/adminLogin")
    public ModelAndView login(HttpServletRequest req) {

        if (req.getParameter("login") == null) {
            ModelAndView model = new ModelAndView("adminLogin");
            return model;
        } else {
            ModelAndView model = new ModelAndView("adminInfo");
            String login = req.getParameter("login");
            String pass = req.getParameter("pass");


            Admin a = null;

            try {
                a = admin.getAdmin(adminService.getAdminByLogin(login));
                System.out.println(a.getLogin());
            } catch (NullPointerException e) {
                model.addObject("info", "Неверное имя пользователя");
            }
            if (a == null) {
                model.addObject("info", "Неверное имя пользователя");
            } else {
                /**
                 * If login taken from db correct, check password and send User to session, log in.
                 */
                if (a.getPassword().equals(pass)) {
                    HttpSession s = req.getSession();
                    s.setAttribute("admin", a);
                    model.addObject("info", "Авторизация прошла успешно");
                } else {
                    model.addObject("info", "Неверный пароль");
                }
            }
            return model;
        }
    }
}

