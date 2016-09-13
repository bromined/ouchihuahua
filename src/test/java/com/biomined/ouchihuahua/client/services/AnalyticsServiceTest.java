package com.biomined.ouchihuahua.client.services;

import com.biomined.ouchihuahua.server.services.AnalyticsService;
import com.biomined.ouchihuahua.server.services.AnalyticsServiceImpl;
import junit.framework.TestCase;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsServiceTest extends TestCase {

    private AnalyticsService analyticsService = new AnalyticsServiceImpl();

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetWordFrequency() throws Exception {

        TreeMap<Integer, List<String>> wordFrequency = analyticsService.getWordFrequency("1");
        assertTrue(wordFrequency != null && !wordFrequency.isEmpty());

    }

    public void testGetWordFrequency1() throws Exception {

    }
}