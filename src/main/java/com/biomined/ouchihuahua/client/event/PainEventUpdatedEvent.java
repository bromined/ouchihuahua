package com.biomined.ouchihuahua.client.event;

import com.biomined.ouchihuahua.shared.model.PainEventDTO;
import com.google.gwt.event.shared.GwtEvent;

public class PainEventUpdatedEvent extends GwtEvent<PainEventUpdatedEventHandler> {
    public static Type<PainEventUpdatedEventHandler> TYPE = new Type<PainEventUpdatedEventHandler>();
    private final PainEventDTO updatedPainEvent;

    public PainEventUpdatedEvent(PainEventDTO updatedPainEvent) {
        this.updatedPainEvent = updatedPainEvent;
    }

    public PainEventDTO getUpdatedPainEvent() {
        return updatedPainEvent;
    }


    @Override
    public Type<PainEventUpdatedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PainEventUpdatedEventHandler handler) {
        handler.onPainEventUpdated(this);
    }
}
