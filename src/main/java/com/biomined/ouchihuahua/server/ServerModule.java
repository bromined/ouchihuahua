/*
 * Created by IntelliJ IDEA.
 * User: scole
 * Date: 11/4/14
 * Time: 3:56 PM
 */
package com.biomined.ouchihuahua.server;

import com.biomined.ouchihuahua.server.dao.*;
import com.biomined.ouchihuahua.server.services.*;
import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {

    protected void configure() {

        bind(UserDao.class).to(UserDaoImpl.class);
        bind(EventDao.class).to(EventDaoImpl.class);

        bind(AnalyticsService.class).to(AnalyticsServiceImpl.class);
        bind(WeatherService.class).to(WeatherServiceImpl.class);

    }
}
