package com.biomined.ouchihuahua.server.services;

import com.biomined.ouchihuahua.shared.model.Analyzable;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by scole on 8/22/14.
 */
public interface WeatherService {

    /*
        should probably store historical weather data in database, and have a record pointer in the pain event table.
        This way multiple accounts can use the same weather data and don't have to re-fetch it. Forecasts should be
        re-fetched daily.
     */

    /**
     * @param latitude
     * @param longitude
     * @return data and type
     * @throws Exception
     */
    Analyzable getCurrentWeatherData(double latitude, double longitude) throws Exception;

    Analyzable getHistoricalWeatherData(String stationId) throws Exception;

    Analyzable getForecastWeatherData(String stationId) throws Exception;

    Analyzable getWeatherWindow(double latitude, double longitude) throws IOException, JSONException;

}
