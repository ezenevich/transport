package com.transport.admin;

import com.transport.instance.AdminInstance;
import lombok.*;


@ToString
@NoArgsConstructor

public class Admin {
    private int id;

    private String login;

    private String password;



    public String getLogin(){ return this.login; }
    public String getPassword(){ return this.password; }
    public int getId(){ return this.id; }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Admin getAdmin(AdminInstance admin){
        Admin a = new Admin();
        a.withId(admin.getId()).withLogin(admin.getLogin()).withPassword(admin.getPassword());
        return a;
    }

    public Admin withId(int id) {
        this.id = id;
        return this;
    }

    public Admin withLogin(String login) {
        this.login = login;
        return this;
    }

    public Admin withPassword(String pass) {
        this.password = pass;
        return this;
    }
}
