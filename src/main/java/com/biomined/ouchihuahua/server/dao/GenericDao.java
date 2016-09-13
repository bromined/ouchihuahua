package com.biomined.ouchihuahua.server.dao;

import java.util.Map;

/**
 * http://www.codeproject.com/Articles/251166/The-Generic-DAO-pattern-in-Java-with-Spring-and
 * Created by scole on 11/6/14.
 */
public interface GenericDao<T> {

    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params
     *            sql parameters
     * @return the number of records meeting the criteria
     */
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Long id);

    T find(Long id);

    T update(T t);
}
