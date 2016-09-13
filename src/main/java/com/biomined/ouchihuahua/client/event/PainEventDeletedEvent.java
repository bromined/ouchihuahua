package com.biomined.ouchihuahua.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PainEventDeletedEvent extends GwtEvent<PainEventDeletedEventHandler> {
    public static Type<PainEventDeletedEventHandler> TYPE = new Type<PainEventDeletedEventHandler>();

    @Override
    public Type<PainEventDeletedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PainEventDeletedEventHandler handler) {
        handler.onPainEventDeleted(this);
    }
}
