package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/25/13
 * Time: 1:28 PM
 */
public interface PainEventCreatedEventHandler extends EventHandler {
    void onPainEventCreated(PainEventCreatedEvent painEventCreatedEvent);
}
