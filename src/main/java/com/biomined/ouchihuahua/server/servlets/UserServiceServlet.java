package com.biomined.ouchihuahua.server.servlets;

import com.biomined.ouchihuahua.client.services.UserService;
import com.biomined.ouchihuahua.server.dao.UserDao;
import com.biomined.ouchihuahua.server.dao.UserDaoImpl;
import com.biomined.ouchihuahua.shared.model.User;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:48 PM
 */
public class UserServiceServlet extends RemoteServiceServlet implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserDTO authenticate(String username, String passwordHash) {

        User user = userDao.findUserByName(username);

        if (user != null) {
            if (passwordHash != null && user.getPasswordHash() != null && passwordHash.equals(user.getPasswordHash())) {
                return new UserDTO(user);
            }
        }
        return null;
    }

    @Override
    public UserDTO register(String userName, String password) {

        if (userDao.userExists(userName)) {
            return null;
        }

        User user = userDao.create(new User(userName, password));

        return new UserDTO(user);
    }

    @Override
    public UserDTO login(String username, String passwordHash) {

        User user = userDao.findUserByName(username);
        if (BCrypt.checkpw(passwordHash, user.getPasswordHash())) {
            return new UserDTO(user);
        }
        return null;
    }

    public void delete(String username) {

        User user = userDao.findUserByName(username);

        if (user != null) {
            userDao.delete(user.getId());
        }
    }
}