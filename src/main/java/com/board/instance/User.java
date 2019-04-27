package com.board.instance;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@ToString
@Entity
@Table(name = "mvcusers")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String pass;

    private String fav;

    @Column(nullable = false)
    private String phone;

    public User(String login, String pass, String fav, String phone) {
        this.login = login;
        this.pass = pass;
        this.fav = fav;
        this.phone = phone;
    }

    public User() {
    }

    public User(int id, String login, String pass, String fav, String phone) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.fav = fav;
        this.phone = phone;
    }

    public String getLogin(){ return  login; }
    public String getPass(){ return  pass; }
    public String getPhone(){ return  phone; }
    public String getFav(){ return  fav; }
    public int getId(){ return  id; }

}
