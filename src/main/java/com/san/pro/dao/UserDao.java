/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.dao;

import com.san.pro.model.User;

public interface UserDao {

    User getById(long id);

    User save(User user);

}
