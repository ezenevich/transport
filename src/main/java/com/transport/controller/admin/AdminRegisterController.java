
package com.transport.controller.admin;

import com.transport.instance.AdminInstance;
import com.transport.instance.UserInstance;
import com.transport.service.AdminService;
import com.transport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminRegisterController {


    @Autowired
    @Qualifier(value = "adminService")
    private AdminService adminService;

    @RequestMapping("/adminReg")
    public ModelAndView register(HttpServletRequest req) {
        String login = req.getParameter("login");
        if (login == null) {
            ModelAndView model = new ModelAndView("adminReg");
            return model;
        } else {
            ModelAndView model = new ModelAndView("infoRegAdmin");
            if (adminService.getAdminByLogin(login) == null) {
                AdminInstance adminInstance = new AdminInstance(login, req.getParameter("pass"));
                adminService.addAdmin(adminInstance);
                model.addObject("info", "Регистрация прошла успешна!!!");
            } else {
                model.addObject("info", "Администратор с таким именем уже есть.");
            }
            return model;
        }
    }
}
