package com.biomined.ouchihuahua.shared.model;

/**
 * Created by scole on 9/27/14.
 */
public enum Type {
    WEATHER("weather");
    private String label;

    Type(String label) {

        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
