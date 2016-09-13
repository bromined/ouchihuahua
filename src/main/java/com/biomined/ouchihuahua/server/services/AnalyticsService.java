package com.biomined.ouchihuahua.server.services;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by scole on 8/22/14.
 */
public interface AnalyticsService {

    public TreeMap<Integer, List<String>> getWordFrequency(String userId);

    public TreeMap<Integer, List<String>> getWordFrequency(String userId, Date startDate, Date endDate);

}
