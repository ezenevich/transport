package com.transport.dao.impl;


import com.transport.admin.Admin;
import com.transport.dao.AdminDAO;
import com.transport.instance.AdminInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AdminDAOImlp implements AdminDAO {

    private static final Logger logger = Logger.getLogger(AdminDAO.class);

    @Autowired
    private HibernateTemplate template;


    public List<AdminInstance> getAdmins() {
        logger.info("Get all admins from db");
        return template.loadAll(AdminInstance.class);
    }

    public AdminInstance getAdminByLogin(String login) {
        logger.info("Admin with login " + login + " was getted from db");
        List<AdminInstance> r = (List<AdminInstance>) template.find("from AdminInstance a where a.login = ?", login);
        if ( r.isEmpty() ) {
            return null;
        }
        return (AdminInstance)r.get(0);
    }

    public void addAdmin(AdminInstance admin) {
        template.save(admin);
        logger.info("Add new admin with login " + admin.getLogin());
    }

    public void updateAdmin(AdminInstance admin) {
        template.update(admin);
        logger.info("Update admin with login " + admin.getLogin());
    }

    public void deleteAdmin(AdminInstance admin){
        template.delete(admin);
        logger.info("Delete admin with login " + admin.getLogin());
    }
}
