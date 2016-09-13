package com.biomined.ouchihuahua.server.webservices;

import org.json.JSONObject;
import org.json.JSONString;

/**
 * Created by scole on 9/26/14.
 */
public interface UserService {

    JSONString login(String username, String password);

    JSONObject register(String username, String password);

    JSONObject authenticate(String username, String passwordHash);
}
