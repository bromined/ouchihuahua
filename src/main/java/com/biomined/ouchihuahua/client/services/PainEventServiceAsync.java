package com.biomined.ouchihuahua.client.services;

import com.biomined.ouchihuahua.shared.model.PainEventDTO;
import com.biomined.ouchihuahua.shared.model.PainEventSummary;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:49 PM
 */
public interface PainEventServiceAsync {

    void createPainEvent(PainEventDTO painEventDTO, AsyncCallback<PainEventDTO> async);

    void updatePainEvent(PainEventDTO painEventDTO, AsyncCallback<Void> async);

    void getPainEventSummaryList(Long userId, AsyncCallback<ArrayList<PainEventSummary>> async);

    void getPainEvent(Long eventId, AsyncCallback<PainEventDTO> async);

    void deletePainEvent(UserDTO user, String eventId, AsyncCallback<Void> async);
}

