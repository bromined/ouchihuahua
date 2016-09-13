package com.biomined.ouchihuahua.server.dao;

import com.biomined.ouchihuahua.shared.model.Event;

import java.util.ArrayList;

/**
 * Created by scole on 11/24/14.
 */
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao {
    @Override
    public ArrayList<Event> findAllByUserId(Long userId) {
        return null;
    }
}
