package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/1/13
 * Time: 1:24 PM
 */
public interface SuccessfulLoginEventHandler extends EventHandler {
    void onSuccessfulLoginEvent(SuccessfulLoginEvent successfulLoginEvent);
}
