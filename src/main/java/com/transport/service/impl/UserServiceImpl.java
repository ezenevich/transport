package com.transport.service.impl;

import com.transport.dao.UserDAO;
import com.transport.instance.UserInstance;
import com.transport.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {


    private UserDAO udao;

    @Autowired
    public void setUserService(UserDAO udao) {
        this.udao = udao;
    }

    public List<UserInstance> getUsers() {
        return udao.getUsers();
    }

    public UserInstance getUserByLogin(String login) {
        return udao.getUserByLogin(login);
    }

    public void addUser(UserInstance user) {
        udao.addUser(user);
    }

    public void updateUser(UserInstance user) {
        udao.updateUser(user);
    }

    public void deleteUser(UserInstance user) {
        udao.deleteUser(user);
    }


}
