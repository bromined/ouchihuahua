package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/20/13
 * Time: 4:44 PM
 */
public interface AuthenticateEventHandler extends EventHandler {
    void onAuthenticateEvent(AuthenticateEvent authenticateEvent);
}
