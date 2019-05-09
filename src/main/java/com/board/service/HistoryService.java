package com.board.service;

import com.board.data.Favorites;
import com.board.data.History;
import com.board.instance.Item;
import com.board.item.ItemForOwner;
import com.board.user.UserForSession;

import java.util.List;


public interface HistoryService {

    History updateHist(History hist, String sId);

    List<ItemForOwner> crudHist(UserForSession userForSession, String id, List<Item> listItems);

    void updateHist(UserForSession userForSession, String id);

    Integer stringToInteger(String sInt);
}
