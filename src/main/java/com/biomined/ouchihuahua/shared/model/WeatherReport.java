package com.biomined.ouchihuahua.shared.model;

/**
 * Created by scole on 9/30/14.
 */
public class WeatherReport implements Analyzable {

    private final Type type;
    private final Object data;

    public WeatherReport(Type type, Object data) {

        this.type = type;
        this.data = data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public Type getType() {
        return type;
    }

}
