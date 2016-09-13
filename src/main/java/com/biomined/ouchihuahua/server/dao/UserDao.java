package com.biomined.ouchihuahua.server.dao;

import com.biomined.ouchihuahua.shared.model.User;

/**
 * Created by IntelliJ IDEA.
 * IUser: stephencole
 * Date: 4/23/13
 * Time: 4:46 PM
 */
public interface UserDao extends GenericDao<User>{


    User findUserByName(String username);

    boolean userExists(String userName);

}
