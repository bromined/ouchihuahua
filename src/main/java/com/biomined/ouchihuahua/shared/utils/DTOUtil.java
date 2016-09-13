package com.biomined.ouchihuahua.shared.utils;

import com.biomined.ouchihuahua.shared.model.PainEvent;
import com.biomined.ouchihuahua.shared.model.PainEventSummary;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/22/13
 * Time: 4:26 PM
 */
public class DTOUtil {

    public static ArrayList<PainEventSummary> buildSummaryList(ArrayList<PainEvent> painEvents) {

        ArrayList<PainEventSummary> painEventSummaries = new ArrayList<PainEventSummary>();

        if (!painEvents.isEmpty()) {

            for (PainEvent painEvent : painEvents) {

                painEventSummaries.add(new PainEventSummary(painEvent));
            }

        }

        return painEventSummaries;
    }
}
