package com.board.service;

import com.board.data.Favorites;
import com.board.item.ItemForOwner;
import com.board.user.UserForSession;
import com.board.instance.Item;

import java.util.List;


public interface FavoriteService {

    Favorites updateFav(Favorites fav, String sId);

    List<ItemForOwner> crudFavorites(UserForSession userForSession, String id, List<Item> listItems);

    void updateFavorites(UserForSession userForSession, String id);

    Integer stringToInteger(String sInt);
}
