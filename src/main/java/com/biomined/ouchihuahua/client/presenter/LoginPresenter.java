package com.biomined.ouchihuahua.client.presenter;

import com.biomined.ouchihuahua.client.dao.LocalStorage;
import com.biomined.ouchihuahua.client.event.ForgotPasswordEvent;
import com.biomined.ouchihuahua.client.event.RegistrationEvent;
import com.biomined.ouchihuahua.client.event.SuccessfulLoginEvent;
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
 * Date: 6/20/13
 * Time: 2:28 PM
 */
public class LoginPresenter implements Presenter {

    private UserServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;

    public interface Display {

        HasTapHandlers getLoginButton();

        HasTapHandlers getRegisterButton();

        HasTapHandlers getForgotPasswordButton();

        String getUserName();

        String getPassword();

        Widget asWidget();

        Boolean getRememberMe();

    }

    public LoginPresenter(UserServiceAsync rpcService, HandlerManager eventBus, Display display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    public void bind() {

        this.display.getLoginButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent tapEvent) {

                if (isValid()) {
                    doLogin();
                }
            }
        });

        this.display.getRegisterButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent tapEvent) {
                eventBus.fireEvent(new RegistrationEvent());
            }
        });


        this.display.getForgotPasswordButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent tapEvent) {
                eventBus.fireEvent(new ForgotPasswordEvent());
            }
        });
    }

    private boolean isValid() {

        if (!display.getUserName().isEmpty() && !display.getPassword().isEmpty()) {
            return true;
        }
        return false;
    }

    private void doLogin() {

        rpcService.login(display.getUserName(), display.getPassword(), new AsyncCallback<UserDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getLocalizedMessage());
            }

            @Override
            public void onSuccess(UserDTO user) {

                //Todo double check this logic
                if (user == null) {
                    eventBus.fireEvent(new RegistrationEvent());
                }

                if (display.getRememberMe()) {
                    LocalStorage.putUser(user != null ? user.getUsername() : null, user.getPasswordHash());
                }

                eventBus.fireEvent(new SuccessfulLoginEvent(user));
            }
        });
    }

    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
}
