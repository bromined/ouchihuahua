package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/20/13
 * Time: 1:29 PM
 */
public interface LoginEventHandler extends EventHandler {
    void onLoginEvent(LoginEvent loginEvent);
}
