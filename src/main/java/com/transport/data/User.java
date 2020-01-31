package com.transport.data;

import com.transport.instance.UserInstance;

public class User {
    private int id;
    private String login;
    private String password;
    private int orderId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser(UserInstance user){
        User u = new User();
        u.withId(user.getId()).withLogin(user.getLogin()).withPassword(user.getPassword()).withOrderId(user.getOrderId());
        return u;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }
    public User withLogin(String login) {
        this.login = login;
        return this;
    }
    public User withPassword(String pass) {
        this.password = pass;
        return this;
    }
    public User withOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

}
