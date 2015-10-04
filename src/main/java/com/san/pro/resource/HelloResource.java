/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.resource;

import com.san.pro.config.MessagesConfiguration;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path(value = "/hello")
public class HelloResource {

    private final MessagesConfiguration messagesConfiguration;

    @Inject
    public HelloResource(final MessagesConfiguration messagesConfiguration) {
        this.messagesConfiguration = messagesConfiguration;
    }

    @GET
    public String sayHello() {
        return messagesConfiguration.getHello();
    }

    @POST
    @Path("/{id}")
    public String parameterDemoMethod(String body,
                                      @PathParam("id") long id,
                                      @QueryParam("foo") String foo,
                                      @HeaderParam("X-Auth-Token") String token,
                                      @Context HttpServletRequest request) {
        String response;
        response = "id = " + id + "\n";
        response += "body = " + body + "\n";
        response += "foo = " + foo + "\n";
        response += "token = " + token + "\n";
        response += "ip = " + request.getRemoteAddr() + "\n";
        return response;
    }

}
