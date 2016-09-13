package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/9/13
 * Time: 1:34 PM
 */
public class RegistrationEvent extends GwtEvent<RegistrationEventHandler> {

    public static Type<RegistrationEventHandler> TYPE = new Type<RegistrationEventHandler>();

    @Override
    public Type<RegistrationEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RegistrationEventHandler handler) {
        handler.onRegistrationEvent(this);
    }
}
