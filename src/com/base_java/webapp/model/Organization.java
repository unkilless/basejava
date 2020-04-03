package com.base_java.webapp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Organization {
    private UrlField organisationInfo;
    private List<Position> positions;

    public Organization(String organisation, String url, List<Position> positions) {
        Objects.requireNonNull(positions, "Pls enter your position");
        this.organisationInfo = new UrlField(organisation, url);
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(organisationInfo, that.organisationInfo) &&
                Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisationInfo, positions);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organisationInfo=" + organisationInfo +
                ", positions=" + positions +
                '}';
    }

    public UrlField getOrganisationInfo() {
        return organisationInfo;
    }

    public List<Position> getPositions() {
        return positions;
    }

    private class Position {
        private String title;
        private String description;
        private LocalDate dateStart;
        private LocalDate dateEnd;
    }
}
