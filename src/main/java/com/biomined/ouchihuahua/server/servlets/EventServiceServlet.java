package com.biomined.ouchihuahua.server.servlets;

import com.biomined.ouchihuahua.client.services.PainEventService;
import com.biomined.ouchihuahua.server.dao.EventDao;
import com.biomined.ouchihuahua.server.dao.EventDaoImpl;
import com.biomined.ouchihuahua.server.dao.UserDao;
import com.biomined.ouchihuahua.server.dao.UserDaoImpl;
import com.biomined.ouchihuahua.shared.model.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:49 PM
 */
public class EventServiceServlet extends RemoteServiceServlet implements PainEventService {

    private EventDao eventDao = new EventDaoImpl();
    private UserDao userDao = new UserDaoImpl();


    @Override
    public ArrayList<PainEventSummary>
    getPainEventSummaryList(Long userId) {

        ArrayList<Event> painEvents = eventDao.findAllByUserId(userId);

//        if (painEvents != null) {
//            return DTOUtil.buildSummaryList(painEvents);
//        }
        return null;
    }

    @Override
    public PainEventDTO getPainEvent(Long eventId) {

//        PainEvent painEvent = eventDao.find(eventId);
//
//        if (painEvent != null) {
//            return new PainEventDTO(painEvent);
//        }
        return null;
    }


    @Override
    public PainEventDTO createPainEvent(PainEventDTO painEventDTO) {

        if (painEventDTO != null) {

//            if (isAuthenticated(painEventDTO.getUserDTO())) {
//
//                PainEvent painEvent = eventDao.create(new PainEvent(painEventDTO));
//
//                if (painEvent != null) {
//                    return new PainEventDTO(painEvent);
//                }
//            }
        }
        return null;
    }

    @Override
    public void updatePainEvent(PainEventDTO painEventDTO) {
        if (isAuthenticated(painEventDTO.getUserDTO())) {
//            eventDao.update(new PainEvent(painEventDTO));
        }
    }

    @Override
    public void deletePainEvent(UserDTO user, String eventId) {

        if (isAuthenticated(user)) {
            eventDao.delete(Long.valueOf(eventId));
        }
    }

    private boolean isAuthenticated(UserDTO userToAuth) {

        User user = userDao.find(userToAuth.getId());
        if (user != null) {
            return user.getPasswordHash().equals(userToAuth.getPasswordHash());
        }
        return false;
    }
}