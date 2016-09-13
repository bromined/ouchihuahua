package com.biomined.ouchihuahua.server.webservices;

import com.biomined.ouchihuahua.server.services.WeatherService;
import com.biomined.ouchihuahua.server.services.WeatherServiceImpl;
import com.biomined.ouchihuahua.shared.model.Analyzable;
import junit.framework.TestCase;

public class WeatherServiceTest extends TestCase {

    private WeatherService weatherService = new WeatherServiceImpl();
    private float lat = 34.1205815f;
    private float lon = -84.1686743f;
    private String stationId = "6331909";

    public void testGetCurrentWeatherData() throws Exception {

        Analyzable currentWeatherData = weatherService.getCurrentWeatherData(lat, lon);
        assertNotNull(currentWeatherData);
    }

    public void testGetWeatherWindow() throws Exception {


        Analyzable weatherWindow = weatherService.getWeatherWindow(lat, lon);
        assertNotNull(weatherWindow);


    }

}