package com.transport.service;

import com.transport.instance.UserInstance;
import java.util.List;


public interface UserService {

    List<UserInstance> getUsers();

    UserInstance getUserByLogin(String login);

    void addUser(UserInstance user);

    void updateUser(UserInstance user);

    void deleteUser(UserInstance user);
}
