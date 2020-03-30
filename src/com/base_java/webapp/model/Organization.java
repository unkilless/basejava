package com.base_java.webapp.model;

import java.util.Objects;

public class Organization {
    private String dateStart;
    private String dateEnd;
    private String organisation;
    private String position;
    private String description;
    private UrlField homePage;

    public Organization( String dateStart, String dateEnd, String organisation, String position, String description, UrlField homePage) {
        Objects.requireNonNull(organisation, "Pls enter correct dates");
        Objects.requireNonNull(position, "Pls enter your position");
        Objects.requireNonNull(dateStart, "Pls enter start date");
        this.organisation = organisation;
        this.position = position;
        this.description = description;
        this.homePage = homePage;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateEnd, that.dateEnd) &&
                Objects.equals(organisation, that.organisation) &&
                Objects.equals(position, that.position) &&
                Objects.equals(description, that.description) &&
                Objects.equals(homePage, that.homePage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd, organisation, position, description, homePage);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", organisation='" + organisation + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", homePage=" + homePage +
                '}';
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getDateStart() {
        return dateStart;
    }

    public UrlField getHomePage() {
        return homePage;
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
