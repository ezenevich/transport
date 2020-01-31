package com.transport.dao;

import com.transport.instance.AdminInstance;

import java.util.List;


public interface AdminDAO {
    List<AdminInstance> getAdmins();

    AdminInstance getAdminByLogin(String login);

    void addAdmin(AdminInstance admin);

    void updateAdmin(AdminInstance admin);

    void deleteAdmin(AdminInstance admin);
}
