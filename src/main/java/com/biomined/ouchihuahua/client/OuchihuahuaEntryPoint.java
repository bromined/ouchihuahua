package com.biomined.ouchihuahua.client;

import com.biomined.ouchihuahua.client.controllers.AppController;
import com.biomined.ouchihuahua.client.dao.LocalStorage;
import com.biomined.ouchihuahua.client.services.UserService;
import com.biomined.ouchihuahua.client.services.UserServiceAsync;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;

import java.util.Map;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class OuchihuahuaEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {

        final UserServiceAsync userServiceAsync = GWT.create(UserService.class);

        // set viewport and other settings for mobile
//        if (MGWT.getOsDetection().isDesktop()) {
//            GWT.log("Detected desktop");
//        } else {
//            GWT.log("Detected mobile device");
//        }
        MGWT.applySettings(MGWTSettings.getAppSetting());

        // build animation helper and attach it
        final AnimationHelper animationHelper = new AnimationHelper();
        RootPanel.get().add(animationHelper);
        final HandlerManager eventBus = new HandlerManager(null);

        final Map<String, String> userMap = LocalStorage.fetchUser();

        if (userMap != null) {

            userServiceAsync.authenticate(userMap.get("username"), userMap.get("passwordHash"), new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {

                    History.newItem("login");
                    AppController appController = new AppController(userServiceAsync, eventBus, animationHelper, null);
                    appController.go(RootPanel.get());
                }

                @Override
                public void onSuccess(UserDTO result) {

                    if (result != null) {

                        History.newItem("list");
                        AppController appController = new AppController(userServiceAsync, eventBus, animationHelper, result);
                        appController.go(RootPanel.get());

                    } else {

                        History.newItem("login");
                        AppController appController = new AppController(userServiceAsync, eventBus, animationHelper, null);
                        appController.go(RootPanel.get());

                    }
                }
            });

        } else {

            History.newItem("login");
            AppController appController = new AppController(userServiceAsync, eventBus, animationHelper, null);
            appController.go(RootPanel.get());
        }
    }
}
