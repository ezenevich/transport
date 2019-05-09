
package com.board.user;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserForSession {
    private int id;

    private String login;

    private String pass;

    private String fav;

    private String hist;

    private String phone;

    public UserForSession withId(int id) {
        this.id = id;
        return this;
    }

    public UserForSession withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserForSession withPass(String pass) {
        this.pass = pass;
        return this;
    }

    public UserForSession withFav(String fav) {
        this.fav = fav;
        return this;
    }
    public UserForSession withHist(String hist) {
        this.hist = hist;
        return this;
    }

    public UserForSession withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFav(){
        return fav;
    }
    public String getHist(){
        return hist;
    }
    public String getLogin(){ return login; }
    public String getPass(){ return pass; }
    public String getPhone(){ return phone; }
    public int getId(){ return id; }

    public void setFav(String fav){
        this.fav = fav;
    }
    public void setHist(String hist){
        this.hist = hist;
    }
}
