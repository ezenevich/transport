package com.board.service.impl;

import com.board.dao.UserDAO;
import com.board.instance.User;
import com.board.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service("userServ")
public class UserServiceImpl implements UserService {


    private UserDAO udao;

    @Autowired
    public void setUserService(UserDAO udao) {
        this.udao = udao;
    }

    public List<User> getUsers() {
        return udao.getUsers();
    }

    public User getUserByLogin(String login) {
        return udao.getUserByLogin(login);
    }

    public void addUser(User u) {
        udao.addUser(u);
    }

    public void updateUser(User user) {
        udao.updateUser(user);
    }

    public void deleteUser(User user) {
        udao.deleteUser(user);
    }


}
