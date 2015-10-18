/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.resource;

import com.san.pro.Error;
import com.san.pro.dao.UserDao;
import com.san.pro.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserDao userDao;

    @Inject
    public UserResource(final UserDao userDao) {
        this.userDao = userDao;
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@Valid User user) {
        userDao.save(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String stringId)
    {
        try {
            Long id = Long.parseLong(stringId);
            User user = userDao.getById(id);
            if(user == null) {
                com.san.pro.Error error = new Error();
                error.setMessage("Entity not found for id: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            return Response.status(Response.Status.OK).entity(user).build();
        } catch(NumberFormatException ex) {
            com.san.pro.Error error = new Error();
            error.setMessage("Invalid ID");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers()
    {
        try {
            List<User> userList = userDao.getAllUsers();
            if(userList == null) {
                com.san.pro.Error error = new Error();
                error.setMessage("No Record found");
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            return Response.status(Response.Status.OK).entity(userList).build();
        } catch(Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}