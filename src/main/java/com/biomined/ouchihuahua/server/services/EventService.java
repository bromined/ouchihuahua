package com.biomined.ouchihuahua.server.services;

import com.biomined.ouchihuahua.shared.model.Event;

import java.util.List;

/**
 * Created by scole on 11/6/14.
 */
public interface EventService {

    public List<Event> getCondensedEventList(Long userId);
    public Event createEvent(Event event);

}
