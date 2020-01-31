package com.transport.instance;

import com.transport.data.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "transport")
public class UserInstance {
    private int id;
    private String login;
    private String password;
    private int orderId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "orderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInstance that = (UserInstance) o;
        return id == that.id &&
                orderId == that.orderId &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, orderId);
    }

    public UserInstance() {
    }

    public UserInstance(int id, String login, String password, int orderId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.orderId = orderId;
    }

    public UserInstance(String login, String password, int orderId) {
        this.login = login;
        this.password = password;
        this.orderId = orderId;
    }
}
