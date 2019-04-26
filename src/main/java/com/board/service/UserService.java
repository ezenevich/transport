package com.board.service;


import com.board.instance.User;

import java.util.List;


public interface UserService {

    List<User> getUsers();

    User getUserByLogin(String login);

    void addUser(User u);

    void updateUser(User user);
}
