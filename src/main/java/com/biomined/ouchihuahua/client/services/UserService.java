package com.biomined.ouchihuahua.client.services;

import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:48 PM
 */
@RemoteServiceRelativePath("UserService")
public interface UserService extends RemoteService {

    UserDTO login(String username, String password);

    UserDTO register(String username, String password);

    UserDTO authenticate(String username, String passwordHash);

}
