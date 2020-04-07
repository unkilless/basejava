package com.base_java.webapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private UrlField organisationInfo;
    private List<Position> positions;

    public Organization(String organisation, String url, Position... positions) {
        this(new UrlField(organisation, url), Arrays.asList(positions));
    }

    public Organization(UrlField organisationInfo, List<Position> positions) {
        Objects.requireNonNull(positions, "Pls enter your position");
        this.organisationInfo = organisationInfo;
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

    public static class Position {
        private String title;
        private String description;
        private LocalDate dateStart;
        private LocalDate dateEnd;

        public Position(String title, String description, LocalDate dateStart, LocalDate dateEnd) {
            Objects.requireNonNull(dateStart, "Pls enter start date");
            Objects.requireNonNull(dateEnd, "Pls enter finish date");
            Objects.requireNonNull(title, "Pls enter your title");
            this.title = title;
            this.description = description;
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public LocalDate getDateStart() {
            return dateStart;
        }

        public LocalDate getDateEnd() {
            return dateEnd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return title.equals(position.title) &&
                    Objects.equals(description, position.description) &&
                    dateStart.equals(position.dateStart) &&
                    dateEnd.equals(position.dateEnd);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, description, dateStart, dateEnd);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", dateStart=" + dateStart +
                    ", dateEnd=" + dateEnd +
                    '}';
        }
    }
}
