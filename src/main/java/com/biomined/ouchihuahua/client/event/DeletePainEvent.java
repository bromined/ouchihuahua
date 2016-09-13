package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;

/**
 * Created by stephencole on 5/16/14.
 */
public class DeletePainEvent extends GwtEvent<DeletePainEventHandler> {

    public static Type<DeletePainEventHandler> TYPE = new Type<DeletePainEventHandler>();
    private TapEvent event;
    private String eventId;

    public DeletePainEvent(TapEvent event, String id) {
        this.event = event;
        this.eventId = id;
    }

    @Override
    public Type<DeletePainEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DeletePainEventHandler handler) {
        handler.onDeletePainEventEvent(this);
    }

    public TapEvent getEvent() {
        return event;
    }

    public String getEventId() {
        return eventId;
    }
}
