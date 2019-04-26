package com.board.dao;

import com.board.instance.User;

import java.util.List;


public interface UserDAO {
    List<User> getUsers();

    User getUserByLogin(String login);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
