package com.transport.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.transport.dao.UserDAO;
import com.transport.instance.UserInstance;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAOImlp implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAO.class);

    @Autowired
    private HibernateTemplate template;

    @Autowired
    private EntityManager entityManager;

    public List<UserInstance> getUsers() {
        logger.info("Get all users from db");
        return template.loadAll(UserInstance.class);
    }

    public UserInstance getUserByLogin(String login) {
        logger.info("User with login " + login + " was getted from db");
        List<UserInstance> r = (List<UserInstance>) template.find("from UserInstance u where u.login = ?", login);
        if ( r.isEmpty() ) {
            return null;
        }
        return ( UserInstance ) r.get( 0 );
    }

    public void addUser(UserInstance user) {
        template.save(user);
        logger.info("Add new user with login " + user.getLogin());
    }

    public void updateUser(UserInstance user) {
        template.update(user);
        logger.info("Update user with login " + user.getLogin());
    }

    public void deleteUser(UserInstance user){
        template.delete(user);
        logger.info("Delete user with login " + user.getLogin());
    }
}
