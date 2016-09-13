package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddPainEvent extends GwtEvent<AddPainEventHandler> {
    public static Type<AddPainEventHandler> TYPE = new Type<AddPainEventHandler>();

    @Override
    public Type<AddPainEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddPainEventHandler handler) {
        handler.onAddPainEvent(this);
    }
}
