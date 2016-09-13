package com.biomined.ouchihuahua.server.dao;

import com.biomined.ouchihuahua.server.ServerModule;
import com.biomined.ouchihuahua.shared.model.User;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:43 PM
 */
public class UserDaoTest {

    @Inject
    UserDao userDao;

    private Injector i;

    @Before
    public void setUp() throws Exception {
        i = Guice.createInjector(new ServerModule());
        userDao = i.getInstance(UserDao.class);
    }

    @Test
    public void testCRUD() throws Exception {

        User user = new User("test", BCrypt.hashpw("test", BCrypt.gensalt()));
        user = userDao.create(user);
        assertNotNull(user);

        user = userDao.find(user.getId());
        assertNotNull(user);

        user = userDao.findUserByName("test");
        assertNotNull(user);

        user.setTags("testtags");
        userDao.update(user);

        User user2 = userDao.find(user.getId());
        assertEquals(user2.getTags(), "testtags");

        userDao.delete(user.getId());

    }

}
