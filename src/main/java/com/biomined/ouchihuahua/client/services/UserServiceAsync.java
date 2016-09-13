package com.biomined.ouchihuahua.client.services;

import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:48 PM
 */
public interface UserServiceAsync {

    void login(String username, String password, AsyncCallback<UserDTO> async);

    void register(String username, String password, AsyncCallback<UserDTO> async);

    void authenticate(String username, String passwordHash, AsyncCallback<UserDTO> async);
}
