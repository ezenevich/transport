package com.transport.service.impl;

import com.transport.dao.AdminDAO;
import com.transport.instance.AdminInstance;
import com.transport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("adminService")
public class AdminServiceImpl implements AdminService {


    private AdminDAO adao;

    @Autowired
    public void setAdminService(AdminDAO adao) {
        this.adao = adao;
    }

    public List<AdminInstance> getAdmins() {
        return adao.getAdmins();
    }

    public AdminInstance getAdminByLogin(String login) {
        return adao.getAdminByLogin(login);
    }

    public void addAdmin(AdminInstance a) {
        adao.addAdmin(a);
    }

    public void updateAdmin(AdminInstance a) {
        adao.updateAdmin(a);
    }

    public void deleteAdmin(AdminInstance a) {
        adao.deleteAdmin(a);
    }

}
