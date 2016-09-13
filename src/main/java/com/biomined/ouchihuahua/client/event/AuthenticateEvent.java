package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/20/13
 * Time: 4:44 PM
 */
public class AuthenticateEvent extends GwtEvent<AuthenticateEventHandler> {

    public static Type<AuthenticateEventHandler> TYPE = new Type<AuthenticateEventHandler>();

    @Override
    public Type<AuthenticateEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AuthenticateEventHandler handler) {
        handler.onAuthenticateEvent(this);
    }
}
