package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditPainEventEvent extends GwtEvent<EditPainEventEventHandler> {
    public static Type<EditPainEventEventHandler> TYPE = new Type<EditPainEventEventHandler>();
    private final String id;

    public EditPainEventEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Type<EditPainEventEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EditPainEventEventHandler handler) {
        handler.onEditPainEvent(this);
    }
}
