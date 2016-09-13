package com.biomined.ouchihuahua.client.services;

import com.biomined.ouchihuahua.shared.model.PainEventDTO;
import com.biomined.ouchihuahua.shared.model.PainEventSummary;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:49 PM
 */
@RemoteServiceRelativePath("PainEventService")
public interface PainEventService extends RemoteService {

    ArrayList<PainEventSummary> getPainEventSummaryList(Long userId);

    PainEventDTO getPainEvent(Long eventId);

    PainEventDTO createPainEvent(PainEventDTO painEventDTO);

    void updatePainEvent(PainEventDTO painEventDTO);

    void deletePainEvent(UserDTO user, String eventId);

    /**
     * Utility/Convenience class.
     * Use PainEventService.App.getInstance() to access static instance of PainEventServiceAsync
     */
    public static class App {
        private static final PainEventServiceAsync ourInstance = (PainEventServiceAsync) GWT.create(PainEventService.class);

        public static PainEventServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
