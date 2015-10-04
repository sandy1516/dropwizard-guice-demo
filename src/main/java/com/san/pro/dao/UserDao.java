package com.san.pro.dao;

import com.san.pro.model.User;

import javax.persistence.PersistenceException;

/**
 * Created by Administrator on 03-10-2015.
 */
public interface UserDao {

    User getById(long id);

    User save(User user);

}
