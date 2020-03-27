package com.base_java.webapp.model;

import java.util.Objects;

public class MapStructValue {
    private String organisation;
    private String position;
    private String description;

    public MapStructValue(String organisation, String position, String description) {
        Objects.requireNonNull(organisation, "Pls enter correct dates");
        Objects.requireNonNull(position, "Pls enter your position");
        this.organisation = organisation;
        this.position = position;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MapElement{" +
                "organisation='" + organisation + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }
}
