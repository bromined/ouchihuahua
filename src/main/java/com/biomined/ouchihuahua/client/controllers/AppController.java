package com.biomined.ouchihuahua.client.controllers;

import com.biomined.ouchihuahua.client.event.*;
import com.biomined.ouchihuahua.client.presenter.*;
import com.biomined.ouchihuahua.client.services.PainEventService;
import com.biomined.ouchihuahua.client.services.PainEventServiceAsync;
import com.biomined.ouchihuahua.client.services.UserServiceAsync;
import com.biomined.ouchihuahua.client.view.EditPainEventView;
import com.biomined.ouchihuahua.client.view.LoginView;
import com.biomined.ouchihuahua.client.view.PainEventListView;
import com.biomined.ouchihuahua.client.view.RegistrationView;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;

public class AppController implements Presenter, ValueChangeHandler<String> {
    private UserServiceAsync userServiceAsync;
    private PainEventServiceAsync painEventServiceAsync;
    private final HandlerManager eventBus;
    private AnimationHelper animationHelper;
    private HasWidgets container;
    private UserDTO user;

    public AppController(UserServiceAsync userServiceAsync, HandlerManager eventBus, AnimationHelper animationHelper, UserDTO user) {
        this.userServiceAsync = userServiceAsync;
        this.eventBus = eventBus;
        this.animationHelper = animationHelper;
        this.user = user;
        bind();
    }

    private void bind() {

        painEventServiceAsync = GWT.create(PainEventService.class);

        History.addValueChangeHandler(this);

        eventBus.addHandler(RegistrationEvent.TYPE, new RegistrationEventHandler() {
            @Override
            public void onRegistrationEvent(RegistrationEvent event) {
                doUserRegistration(event);
            }
        });

        eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
            @Override
            public void onLoginEvent(LoginEvent loginEvent) {
                user = loginEvent.getUser();
                History.newItem("login");
            }
        });

        eventBus.addHandler(SuccessfulRegistrationEvent.TYPE, new SuccessfulRegistrationEventHandler() {
            @Override
            public void onSuccessfulRegistrationEvent(SuccessfulRegistrationEvent successfulRegistrationEvent) {
                user = successfulRegistrationEvent.getUser();
                History.newItem("list");
            }
        });


        eventBus.addHandler(SuccessfulLoginEvent.TYPE, new SuccessfulLoginEventHandler() {
            @Override
            public void onSuccessfulLoginEvent(SuccessfulLoginEvent successfulLoginEvent) {
                user = successfulLoginEvent.getUser();
                History.newItem("list");
            }
        });

        eventBus.addHandler(AddPainEvent.TYPE, new AddPainEventHandler() {
            @Override
            public void onAddPainEvent(AddPainEvent event) {
                History.newItem("new");
            }
        });

        eventBus.addHandler(EditPainEventEvent.TYPE, new EditPainEventEventHandler() {

            @Override
            public void onEditPainEvent(EditPainEventEvent event) {
                doEditEvent(event.getId());
            }
        });

        eventBus.addHandler(EditPainEventCancelledEvent.TYPE, new EditPainEventCancelledEventHandler() {
            @Override
            public void onEditPainEventCancelled(EditPainEventCancelledEvent event) {
                History.newItem("list");
            }
        });

        eventBus.addHandler(PainEventUpdatedEvent.TYPE, new PainEventUpdatedEventHandler() {
            @Override
            public void onPainEventUpdated(PainEventUpdatedEvent painEventUpdatedEvent) {
//                List<PainEvent> painEvents = user.getPainEvents();
//                PainEvent updatedPainEvent = painEventUpdatedEvent.getUpdatedPainEvent();
//                int i = painEvents.indexOf(updatedPainEvent);
//
//                if (i >= 0) {
//                    painEvents.set(i, updatedPainEvent);
//                }
                History.newItem("list");
            }
        });

        eventBus.addHandler(PainEventCreatedEvent.TYPE, new PainEventCreatedEventHandler() {
            @Override
            public void onPainEventCreated(PainEventCreatedEvent painEventCreatedEvent) {
//                user.getPainEvents().add(painEventCreatedEvent.getPainEventDTO());
                History.newItem("list");
            }
        });

        eventBus.addHandler(DeletePainEvent.TYPE, new DeletePainEventHandler() {
            @Override
            public void onDeletePainEventEvent(DeletePainEvent event) {

                if (event != null && event.getEventId() != null) {

                    painEventServiceAsync.deletePainEvent(user, event.getEventId(), new AsyncCallback<Void>() {
                        @Override
                        public void onFailure(Throwable caught) {

                        }

                        @Override
                        public void onSuccess(Void result) {
                            History.newItem("list");
                        }
                    });
                }

            }
        });
    }

    private void doUserRegistration(RegistrationEvent registrationEvent) {
        History.newItem("registration");
    }

    private void doEditEvent(String id) {

        History.newItem("edit", false);
        Presenter presenter = new EditEventPresenter(painEventServiceAsync, eventBus, user, new EditPainEventView(), id);
        presenter.go(container);
    }

    public void go(final HasWidgets container) {

        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("login");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    public void onValueChange(ValueChangeEvent<String> event) {

        String token = event.getValue();

        if (token != null) {

            GWT.log(token + " event fired");
            Presenter presenter = null;

            if (token.equals("registration")) {
                presenter = new RegistrationPresenter(userServiceAsync, eventBus, new RegistrationView());

            } else if (token.equals("login")) {
                presenter = new LoginPresenter(userServiceAsync, eventBus, new LoginView());
            }

            if (token.equals("list")) {
                presenter = new PainEventListPresenter(painEventServiceAsync, eventBus, new PainEventListView(), user);
            }

            if (token.equals("edit")) {
                presenter = new EditEventPresenter(painEventServiceAsync, eventBus, user, new EditPainEventView(), null);
            }

            if (token.equals("new")) {
                presenter = new EditEventPresenter(painEventServiceAsync, eventBus, user, new EditPainEventView(), null);
            }

            if (presenter != null) {
                presenter.go(container);
            }
        }
    }
}
