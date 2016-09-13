package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditPainEventCancelledEvent extends GwtEvent<EditPainEventCancelledEventHandler> {
    public static Type<EditPainEventCancelledEventHandler> TYPE = new Type<EditPainEventCancelledEventHandler>();

    @Override
    public Type<EditPainEventCancelledEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EditPainEventCancelledEventHandler handler) {
        handler.onEditPainEventCancelled(this);
    }
}
