
package com.board.user;

import com.board.data.Favorites;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.board.instance.User;


public class UserConverter {

    @Autowired
    @Qualifier(value = "fav")
    private Favorites favorites;

    public User userToRegister(String login, String pass, String phone) {
        String favor = new Gson().toJson(favorites);
        User user = new User(login, pass, favor, phone);
        return user;
    }

    public UserForSession userSession(User user) {
        UserForSession userForSession = new UserForSession();
        userForSession.withId(user.getId()).withLogin(user.getLogin()).withPass(user.getPass()).withFav(user.getFav()).withPhone(user.getPhone());
        return userForSession;
    }

    public User sessionForUser(UserForSession ufs) {
        User user = new User(ufs.getId(), ufs.getLogin(), ufs.getPass(), ufs.getFav(), ufs.getPhone());
        return user;
    }

    public UserForOwner userForOwner(User user) {
        UserForOwner userForOwner = new UserForOwner();
        userForOwner.withLogin(user.getLogin()).withPhone(user.getPhone());
        return userForOwner;
    }
}
