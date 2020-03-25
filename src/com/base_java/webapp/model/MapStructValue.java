package com.base_java.webapp.model;

import java.util.Objects;

public class MapStructValue {
    protected String dates;
    protected String position;
    protected String description;

    public MapStructValue(String dates, String position, String description) {
        Objects.requireNonNull(dates, "Pls enter correct dates");
        Objects.requireNonNull(dates, "Pls enter your position");
        this.dates = dates;
        this.position = position;
        this.description = description;
    }

    public String getDates() {
        return dates;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }
}
