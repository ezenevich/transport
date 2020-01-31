package com.transport.instance;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@ToString
@Entity
@Table(name = "admin", schema = "transport")
public class AdminInstance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;


    public AdminInstance(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AdminInstance() {
    }

    public AdminInstance(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin(){ return  login; }
    public String getPassword(){ return  password; }
    public int getId(){ return  id; }



}
