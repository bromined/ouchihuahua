package com.biomined.ouchihuahua.client.event;

import com.biomined.ouchihuahua.shared.model.PainEventDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/25/13
 * Time: 1:28 PM
 */
public class PainEventCreatedEvent extends GwtEvent<PainEventCreatedEventHandler> {
    public static Type<PainEventCreatedEventHandler> TYPE = new Type<PainEventCreatedEventHandler>();
    private final PainEventDTO painEventDTO;

    public PainEventCreatedEvent(PainEventDTO painEvent) {
        this.painEventDTO = painEvent;
    }

    public PainEventDTO getPainEventDTO() {
        return painEventDTO;
    }

    @Override
    public Type<PainEventCreatedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PainEventCreatedEventHandler handler) {
        handler.onPainEventCreated(this);
    }
}
