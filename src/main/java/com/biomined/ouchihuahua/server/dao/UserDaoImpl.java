package com.biomined.ouchihuahua.server.dao;

import com.biomined.ouchihuahua.shared.model.User;
import com.google.common.base.Throwables;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * IUser: stephencole
 * Date: 4/23/13
 * Time: 4:46 PM
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public User findUserByName(String username) {

        try {
            EntityManager em = factory.createEntityManager();
            Query q = em.createQuery("Select user FROM User user WHERE user.username = :username");
            q.setParameter("username", username.toLowerCase());

            List resultList = q.getResultList();

            if (resultList.isEmpty()) {
                return null;
            }

            if (resultList.size() > 1) {
                LOG.log(Level.SEVERE, "Found duplicate username " + resultList.toString());
                return null;
            }
            return (User) resultList.get(0);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, Throwables.getStackTraceAsString(e));
            return null;
        }
    }

    @Override
    public boolean userExists(String username) {

        try {
            EntityManager em = factory.createEntityManager();
            Query q = em.createQuery("Select user FROM User user WHERE user.username = :username");
            q.setParameter("username", username.toLowerCase());
            List resultList = q.getResultList();
            return !resultList.isEmpty();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, Throwables.getStackTraceAsString(e));
            return true;
        }
    }


//    @Override
//    public void delete(Long id) {
//        User user = find(id);
//        user.setActive(false);
//        update(user);
//    }
}
