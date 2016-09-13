package com.biomined.ouchihuahua.client.event;

import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/20/13
 * Time: 1:28 PM
 */
public class LoginEvent extends GwtEvent<LoginEventHandler> {

    public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();
    private UserDTO user;

    public LoginEvent(UserDTO user) {
        this.user = user;
    }

    @Override
    public Type<LoginEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoginEventHandler handler) {
        handler.onLoginEvent(this);
    }

    public UserDTO getUser() {
        return user;
    }
}
