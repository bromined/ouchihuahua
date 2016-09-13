package com.biomined.ouchihuahua.client.event;

import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/1/13
 * Time: 1:13 PM
 */
public class SuccessfulLoginEvent extends GwtEvent<SuccessfulLoginEventHandler> {

    public static Type<SuccessfulLoginEventHandler> TYPE = new Type<SuccessfulLoginEventHandler>();
    private UserDTO user;

    public SuccessfulLoginEvent(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    @Override
    public Type<SuccessfulLoginEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SuccessfulLoginEventHandler handler) {
        handler.onSuccessfulLoginEvent(this);
    }
}
