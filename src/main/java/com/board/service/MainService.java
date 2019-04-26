package com.board.service;

import com.board.user.UserForSession;
import com.board.instance.Item;

import java.util.List;


public interface MainService {

    boolean isLogin(UserForSession u);

    List<Item> filterMain(String login, String category);

}
