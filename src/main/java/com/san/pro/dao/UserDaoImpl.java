/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.dao;

import com.san.pro.model.User;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager em = entityManagerFactory.createEntityManager();

    @Override
    public User save(User user) {
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers(){
        List<User> userList = null;
        try {
            CriteriaQuery<User> criteria = em.getCriteriaBuilder().createQuery(User.class);
            criteria.select(criteria.from(User.class));
            userList = em.createQuery(criteria).getResultList();
//            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }


}
