package com.transport.service;


import com.transport.instance.AdminInstance;

import java.util.List;


public interface AdminService {

    List<AdminInstance> getAdmins();

    AdminInstance getAdminByLogin(String login);

    void addAdmin(AdminInstance admin);

    void updateAdmin(AdminInstance admin);

    void deleteAdmin(AdminInstance admin);
}
