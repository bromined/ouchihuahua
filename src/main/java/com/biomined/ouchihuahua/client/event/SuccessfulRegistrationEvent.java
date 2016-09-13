package com.biomined.ouchihuahua.client.event;

import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/21/13
 * Time: 2:43 PM
 */
public class SuccessfulRegistrationEvent extends GwtEvent<SuccessfulRegistrationEventHandler> {

    public static Type<SuccessfulRegistrationEventHandler> TYPE = new Type<SuccessfulRegistrationEventHandler>();
    private UserDTO user;

    public SuccessfulRegistrationEvent(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    @Override
    public Type<SuccessfulRegistrationEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SuccessfulRegistrationEventHandler handler) {
        handler.onSuccessfulRegistrationEvent(this);
    }
}
