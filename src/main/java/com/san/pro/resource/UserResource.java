package com.san.pro.resource;

import com.san.pro.dao.UserDao;
import com.san.pro.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserDao userDao;

    @Inject
    public UserResource(final UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") long id) {
        return userDao.getById(id);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(@Valid User model) {
        User user = new User();
        user.setName(model.getName());
        user.setLogin(model.getLogin());
        user.setPassword(model.getPassword());
        System.out.println(user.toString());
        return userDao.save(user);
    }

}