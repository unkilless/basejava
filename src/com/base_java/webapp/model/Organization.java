package com.base_java.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private UrlField organisationInfo;
    private String position;
    private String description;

    public Organization(LocalDate dateStart, LocalDate dateEnd, String organisation, String url, String position, String description) {
        Objects.requireNonNull(position, "Pls enter your position");
        Objects.requireNonNull(dateStart, "Pls enter start date");
        this.organisationInfo = new UrlField(organisation, url);
        this.position = position;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return dateStart.equals(that.dateStart) &&
                dateEnd.equals(that.dateEnd) &&
                Objects.equals(organisationInfo, that.organisationInfo) &&
                Objects.equals(position, that.position) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd, organisationInfo, position, description);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", organisationInfo=" + organisationInfo +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }
}
