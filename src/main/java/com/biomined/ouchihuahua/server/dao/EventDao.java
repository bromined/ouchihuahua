package com.biomined.ouchihuahua.server.dao;

import com.biomined.ouchihuahua.shared.model.Event;

import java.util.ArrayList;

/**
 * Created by scole on 11/24/14.
 */
public interface EventDao extends GenericDao<Event> {

    ArrayList<Event> findAllByUserId(Long userId);
}
