package com.board.service.impl;

import com.board.data.Favorites;
import com.board.data.History;
import com.board.instance.Item;
import com.board.item.ItemConverter;
import com.board.item.ItemForOwner;
import com.board.service.HistoryService;
import com.board.service.UserService;
import com.board.user.UserConverter;
import com.board.user.UserForSession;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.LinkedList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    public History updateHist(History history, String sId) {
        History updateHist = history;
        Integer id = stringToInteger(sId);
        if (id != null) {
            if (!updateHist.getHist().contains(id)) {
                if (id == 0) {
                    updateHist.getHist().clear();
                }
                if (id > 0) {
                    updateHist.getHist().add(id);
                }
                if (id < 0) {
                    if (updateHist.getHist().size() == 1) {
                        updateHist.getHist().clear();
                    } else {
                        updateHist.removeHist(-id);
                    }
                }
            }
        }
        return updateHist;
    }

    public List<ItemForOwner> crudHist(UserForSession userForSession, String id, List<Item> listItems) {
        History hist = new Gson().fromJson(userForSession.getHist(), History.class);
        History upHist = updateHist(hist, id);
        String backToJsonHist = new Gson().toJson(upHist);
        userForSession.setHist(backToJsonHist);
        userService.updateUser(userConverter.sessionForUser(userForSession));
        List<ItemForOwner> listUpdate = new LinkedList<>();
        listUpdate = itemConverter.listItemForAccount(upHist.getHist(), listItems);
        return listUpdate;
    }

    public void updateHist(UserForSession userForSession, String id) {
        History hist = new Gson().fromJson(userForSession.getHist(), History.class);
        History upHist = updateHist(hist, id);
        String backToJsonHist = new Gson().toJson(upHist);
        userForSession.setHist(backToJsonHist);
        userService.updateUser(userConverter.sessionForUser(userForSession));
    }

    public Integer stringToInteger(String sInt) {
        Integer integer = null;
        if (sInt != null && !sInt.equals("")) {
            integer = Integer.parseInt(sInt);
            return integer;
        }
        return null;
    }
}
