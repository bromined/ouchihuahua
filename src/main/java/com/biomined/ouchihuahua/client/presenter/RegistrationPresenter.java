package com.biomined.ouchihuahua.client.presenter;

import com.biomined.ouchihuahua.client.dao.LocalStorage;
import com.biomined.ouchihuahua.client.event.SuccessfulRegistrationEvent;
import com.biomined.ouchihuahua.client.services.UserServiceAsync;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/9/13
 * Time: 1:24 PM
 */
public class RegistrationPresenter implements Presenter {

    private final Display display;
    private UserServiceAsync rpcService;
    private final HandlerManager eventBus;


    public interface Display {

        HasTapHandlers getRegisterButton();

        String getUserName();

        String getPassword();

        Boolean getRememberMe();

        Widget asWidget();

        String getPasswordConfirmation();
    }

    public RegistrationPresenter(UserServiceAsync rpcService, HandlerManager eventBus, Display display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    public void bind() {

        this.display.getRegisterButton().addTapHandler(new TapHandler() {

            @Override
            public void onTap(TapEvent tapEvent) {

                if (isValid()) {
                    doRegistration();
                }
            }
        });
    }

    private void doRegistration() {

        rpcService.register(display.getUserName(), display.getPassword(), new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getLocalizedMessage());
            }

            @Override
            public void onSuccess(UserDTO user) {

                if (display.getRememberMe()) {
                    LocalStorage.putUser(user.getUsername(), user.getPasswordHash());
                }

                eventBus.fireEvent(new SuccessfulRegistrationEvent(user));
            }
        });
    }

    private boolean isValid() {

        if (!display.getUserName().isEmpty() && !display.getPassword().isEmpty() && display.getPassword().equals(display.getPasswordConfirmation())) {
            return true;
        }

        return false;
    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }


}
