package com.biomined.ouchihuahua.server.services;

import com.biomined.ouchihuahua.shared.model.Analyzable;
import com.biomined.ouchihuahua.shared.model.Type;
import com.biomined.ouchihuahua.shared.model.WeatherReport;
import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherHistoryStationResponse;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by scole on 8/22/14.
 */
public class WeatherServiceImpl implements WeatherService {

//    private static final String GEONAMES_USERNAME = "ouchihuahua";
//
//    @Override
//    public String getLocationName(double latitude, double longitude) throws Exception {
//
//        WebService.setUserName(GEONAMES_USERNAME);
//        List<Toponym> placeName = WebService.findNearbyPlaceName(latitude, longitude);
//
//        if (placeName.get(0) != null) {
//            return placeName.get(0).getName();
//        }
//        return null;
//    }

    @Override
    public Analyzable getCurrentWeatherData(double latitude, double longitude) throws Exception {

        //todo: figure out a weather data caching strategy to prevent repeat calls
        OwmClient owm = new OwmClient();
        owm.setAPPID("933c7116dc90413c8e3e2ae657d1472a");
        WeatherStatusResponse weatherStatusResponse = owm.currentWeatherAtCity((float) latitude, (float) longitude, 1);
        if (weatherStatusResponse.hasWeatherStatus()) {
            Long id = weatherStatusResponse.getWeatherStatus().get(0).getId();
            WeatherHistoryStationResponse weatherHistoryStationResponse = owm.historyWeatherAtStation(id.intValue(), OwmClient.HistoryType.DAY);
        }


        return new WeatherReport(Type.WEATHER, weatherStatusResponse);
    }

    @Override
    public Analyzable getHistoricalWeatherData(String stationId) throws Exception {

        OwmClient owm = new OwmClient();
        owm.setAPPID("933c7116dc90413c8e3e2ae657d1472a");
        WeatherHistoryStationResponse weatherHistoryStationResponse = owm.historyWeatherAtStation(Integer.valueOf(stationId), OwmClient.HistoryType.DAY);

        return null;
    }

    @Override
    public Analyzable getForecastWeatherData(String stationId) throws Exception {

        OwmClient owm = new OwmClient();
        owm.setAPPID("933c7116dc90413c8e3e2ae657d1472a");
        WeatherHistoryStationResponse weatherHistoryStationResponse = owm.historyWeatherAtStation(Integer.valueOf(stationId), OwmClient.HistoryType.DAY);
        return null;
    }

    /*
    I want to get a point and get the previous 3 days and the forecast for the next 3 days. This gives 7 total points, 4 of which are factual.
    Maybe trend up to the current point and accross all point separately

    persist data by stationId..date(1..n)acebook.com

     */

    @Override
    public Analyzable getWeatherWindow(double latitude, double longitude) throws IOException, JSONException {

        WeatherHistoryStationResponse weatherHistoryStationResponse = null;

        OwmClient owm = new OwmClient();
        owm.setAPPID("933c7116dc90413c8e3e2ae657d1472a");
//        JSONObject cityName = owm.getCityName((float) latitude, (float) longitude);
        WeatherStatusResponse weatherStatusResponse = owm.currentWeatherAroundPoint((float) latitude, (float) longitude, 10);

        if (weatherStatusResponse.hasWeatherStatus()) {
            Long stationId = weatherStatusResponse.getWeatherStatus().get(0).getId();
            System.out.println("station id = " + stationId);
            weatherHistoryStationResponse = owm.historyWeatherAtStation(stationId.intValue(), OwmClient.HistoryType.DAY);
        }

        return null;
    }


}
