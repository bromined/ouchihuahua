package com.biomined.ouchihuahua.server.webservices;

import org.json.JSONObject;
import org.json.JSONString;

import javax.ws.rs.*;

/**
 * Created by scole on 9/26/14.
 */
@Path("/user")
public class UserServiceImpl implements UserService {

    @Override
    @POST
    @Produces("text/plain")
    public JSONString login(String username, String password) {
        return null;
    }

    @Override
    @PUT
    @Produces("text/plain")
    public JSONObject register(String username, String password) {
        return null;
    }

    @Override
    @GET
    @Produces("text/plain")
    public JSONObject authenticate(String username, String passwordHash) {
        return null;
    }
}
