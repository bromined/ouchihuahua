package com.biomined.ouchihuahua.client.presenter;

import com.biomined.ouchihuahua.client.event.DeletePainEvent;
import com.biomined.ouchihuahua.client.event.EditPainEventCancelledEvent;
import com.biomined.ouchihuahua.client.event.PainEventCreatedEvent;
import com.biomined.ouchihuahua.client.event.PainEventUpdatedEvent;
import com.biomined.ouchihuahua.client.services.PainEventServiceAsync;
import com.biomined.ouchihuahua.shared.model.PainEventDTO;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import java.util.Date;

public class EditEventPresenter implements Presenter {

    public interface Display {

        HasTapHandlers getSaveButton();

        HasTapHandlers getCancelButton();

        HasValue<Date> getCreationDate();

        HasValue<Date> getOnsetDate();

        HasValue<String> getPainType();

        HasValue<String> getLocation();

        HasValue<String> getNotes();

        HasValue<String> getTags();

        HasValue<String> getRemedies();

        HasValue<Integer> getHoursSlept();

        HasValue<Integer> getSeverity();

        HasTapHandlers getDeleteButton();


        void setLocation(String location);

        Widget asWidget();
    }

    private final HandlerManager eventBus;
    private UserDTO userDTO;
    private PainEventDTO painEventDTO;
    private final Display display;
    private final PainEventServiceAsync painEventServiceAsync;
    private Position position;

    public EditEventPresenter(PainEventServiceAsync painEventServiceAsync, HandlerManager eventBus, UserDTO user, final Display display, String id) {

        this.painEventServiceAsync = painEventServiceAsync;
        this.eventBus = eventBus;
        this.userDTO = user;
        this.display = display;
        bind();

        if (id != null) {

            painEventServiceAsync.getPainEvent(Long.valueOf(id), new AsyncCallback<PainEventDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    GWT.log(caught.getMessage());

                }

                @Override
                public void onSuccess(PainEventDTO painEvent) {

                    painEventDTO = painEvent;

                    if (painEvent.getCreated() != null) {
                        EditEventPresenter.this.display.getCreationDate().setValue(new Date(painEvent.getCreated()));
                    }

                    if (painEvent.getHoursSlept() != null) {
                        EditEventPresenter.this.display.getHoursSlept().setValue(new Integer(painEvent.getHoursSlept()));
                    }

                    if (painEvent.getNotes() != null && !painEvent.getNotes().isEmpty()) {
                        EditEventPresenter.this.display.getNotes().setValue(painEvent.getNotes());
                    }

                    if (painEvent.getOnset() != null) {
                        EditEventPresenter.this.display.getOnsetDate().setValue(new Date(painEvent.getOnset()));
                    }

                    if (painEvent.getPainType() != null && !painEvent.getPainType().isEmpty()) {
                        EditEventPresenter.this.display.getPainType().setValue(painEvent.getPainType());
                    }

                    if (painEvent.getRemedies() != null && !painEvent.getRemedies().isEmpty()) {
                        EditEventPresenter.this.display.getRemedies().setValue(painEvent.getRemedies());
                    }

                    if (painEvent.getSeverity() != null) {
                        EditEventPresenter.this.display.getSeverity().setValue(new Integer(painEvent.getSeverity()));
                    }

                    if (painEvent.getTags() != null && !painEvent.getTags().isEmpty()) {
                        EditEventPresenter.this.display.getTags().setValue(painEvent.getTags());
                    }

                    String latitude = NumberFormat.getFormat("#.##").format(painEvent.getLatitude());
                    String longitude = NumberFormat.getFormat("#.##").format(painEvent.getLongitude());

                    display.setLocation("lat: " + latitude + ", long: " + longitude);

                }
            });

        } else {

            display.getCreationDate().setValue(new Date());
            display.getOnsetDate().setValue(new Date());
            display.getPainType().setValue("Headache");

            if (Geolocation.isSupported()) {

                Geolocation geolocation = Geolocation.getIfSupported();

                if (geolocation != null) {

                    geolocation.getCurrentPosition(new Callback<Position, PositionError>() {

                        @Override
                        public void onFailure(PositionError reason) {
                            Window.alert(reason.getLocalizedMessage());
                        }

                        @Override
                        public void onSuccess(Position result) {

                            position = result;

                            String latitude = NumberFormat.getFormat("#.##").format(result.getCoordinates().getLatitude());
                            String longitude = NumberFormat.getFormat("#.##").format(result.getCoordinates().getLongitude());

                            //todo add timestamp from position object
                            display.setLocation("lat: " + latitude + ", long: " + longitude);
                        }
                    });
                }
            }
        }
    }

    public void bind() {

        this.display.getSaveButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                doSave();
            }
        });

        this.display.getCancelButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                eventBus.fireEvent(new EditPainEventCancelledEvent());
            }
        });

        this.display.getDeleteButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {

                if (Window.confirm("Delete this event?")) {
                    eventBus.fireEvent(new DeletePainEvent(event, painEventDTO.getId()));
                }
            }
        });

        this.display.getOnsetDate();
    }

    public void go(final HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }

    private void doSave() {

        if (painEventDTO == null) {
            painEventDTO = new PainEventDTO();
        }

        if (position != null) {
            painEventDTO.setLatitude(position.getCoordinates().getLatitude());
            painEventDTO.setLongitude(position.getCoordinates().getLongitude());
        }


        Date creationDate = EditEventPresenter.this.display.getCreationDate().getValue();
        if (creationDate != null) {
            painEventDTO.setCreated(creationDate.toLocaleString());
        }

        Integer hoursSlept = EditEventPresenter.this.display.getHoursSlept().getValue();
        if (hoursSlept != null) {
            painEventDTO.setHoursSlept(hoursSlept.toString());
        }

        String notes = EditEventPresenter.this.display.getNotes().getValue();
        if (notes != null && !notes.isEmpty()) {
            painEventDTO.setNotes(notes);
        }

        Date onsetDate = EditEventPresenter.this.display.getOnsetDate().getValue();
        if (onsetDate != null) {
            painEventDTO.setOnset(onsetDate.toLocaleString());
        }

        String painType = EditEventPresenter.this.display.getPainType().getValue();
        if (painType != null) {
            painEventDTO.setType(painType);
        }

        String remedies = EditEventPresenter.this.display.getRemedies().getValue();
        if (remedies != null && !remedies.isEmpty()) {
            painEventDTO.setRemedies(remedies);
        }

        Integer severity = EditEventPresenter.this.display.getSeverity().getValue();
        if (severity != null) {
            painEventDTO.setSeverity(severity.toString());
        }

        String tags = EditEventPresenter.this.display.getTags().getValue();
        if (tags != null && !tags.isEmpty()) {
            painEventDTO.setTags(tags);
        }

        painEventDTO.setUserDTO(userDTO);

        persistPainEvent(painEventDTO);
    }

    private void persistPainEvent(final PainEventDTO painEventDTO) {

        if (painEventDTO.getId() == null) {

            painEventServiceAsync.createPainEvent(painEventDTO, new AsyncCallback<PainEventDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Error creating pain event");
                }

                @Override
                public void onSuccess(PainEventDTO result) {
                    eventBus.fireEvent(new PainEventCreatedEvent(result));
                }
            });

        } else {

            painEventServiceAsync.updatePainEvent(painEventDTO, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Error updating pain event");
                }

                @Override
                public void onSuccess(Void result) {
                    eventBus.fireEvent(new PainEventUpdatedEvent(painEventDTO));
                }
            });
        }
    }
}
