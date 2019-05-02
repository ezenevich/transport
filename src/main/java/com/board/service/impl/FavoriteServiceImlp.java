package com.board.service.impl;

import com.board.data.Favorites;
import com.board.item.ItemConverter;
import com.board.item.ItemForOwner;
import com.board.service.FavoriteService;
import com.board.user.UserConverter;
import com.board.user.UserForSession;
import com.board.instance.Item;
import com.board.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.LinkedList;
import java.util.List;

public class FavoriteServiceImlp implements FavoriteService {

    @Autowired
    @Qualifier(value = "userServ")
    private UserService userService;

    @Autowired
    @Qualifier(value = "userConv")
    private UserConverter userConverter;

    @Autowired
    @Qualifier(value = "itemConv")
    private ItemConverter itemConverter;

    public Favorites updateFav(Favorites favorites, String sId) {
        Favorites updateFav = favorites;
        Integer id = stringToInteger(sId);
        if (id != null) {
            if (!updateFav.getFav().contains(id)) {
                if (id == 0) {
                    updateFav.getFav().clear();
                }
                if (id > 0) {
                    updateFav.getFav().add(id);
                }
                if (id < 0) {
                    if (updateFav.getFav().size() == 1) {
                        updateFav.getFav().clear();
                    } else {
                        updateFav.removeFav(-id);
                    }
                }
            }
        }
        return updateFav;
    }

    public List<ItemForOwner> crudFavorites(UserForSession userForSession, String id, List<Item> listItems) {
        Favorites fav = new Gson().fromJson(userForSession.getFav(), Favorites.class);
        Favorites upFav = updateFav(fav, id);
        String backToJsonFav = new Gson().toJson(upFav);
        userForSession.setFav(backToJsonFav);
        userService.updateUser(userConverter.sessionForUser(userForSession));
        List<ItemForOwner> listUpdate = new LinkedList<>();
        listUpdate = itemConverter.listItemForAccount(upFav.getFav(), listItems);
        return listUpdate;
    }

    public void updateFavorites(UserForSession userForSession, String id) {
        Favorites fav = new Gson().fromJson(userForSession.getFav(), Favorites.class);
        Favorites upFav = updateFav(fav, id);
        String backToJsonFav = new Gson().toJson(upFav);
        userForSession.setFav(backToJsonFav);
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
