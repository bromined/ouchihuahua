package com.biomined.ouchihuahua.server.services;

import com.biomined.ouchihuahua.server.servlets.UserServiceServlet;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/22/13
 * Time: 1:51 PM
 */
public class UserServiceServletTest {

    private UserServiceServlet service = new UserServiceServlet();

    @Test
    public void testRegister() throws Exception {

        //make sure this user isn't in the database aleady
        service.delete("testuser");

        UserDTO userDTO = service.register("testuser", "testpassword");
        assertNotNull(userDTO);

    }

    @Test
    public void testAuthenticate() throws Exception {

        service.register("testuser", "testpassword");

        UserDTO userDTO = service.authenticate("testuser", "testpassword");
        assertNotNull(userDTO);

    }

    @Test
    public void testLogin() throws Exception {

        service.register("testuser", "testpassword");

        UserDTO userDTO = service.login("testuser", "testpassword");
        assertNotNull(userDTO);


    }
}
