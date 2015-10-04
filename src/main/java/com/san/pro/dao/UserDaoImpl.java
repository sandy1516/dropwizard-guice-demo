package com.san.pro.dao;

//import com.google.inject.persist.Transactional;
import com.san.pro.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 03-10-2015.
 */
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getById(long id) {
        return em.find(User.class, id);
    }

    @Override
//    @Transactional

    public User save(User user) {
        try {
            em.persist(user);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
