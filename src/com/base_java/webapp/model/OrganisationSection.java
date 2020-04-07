package com.base_java.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends AbstractSection {
    protected List<Organization> listField;

    public OrganisationSection(Organization... organisations){
        this (Arrays.asList(organisations));
    }

    public OrganisationSection(List<Organization> listField) {
        this.listField = listField;
    }

    public List<Organization> getListField() {
        return listField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganisationSection that = (OrganisationSection) o;
        return Objects.equals(listField, that.listField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listField);
    }

    @Override
    public String toString() {
        return "OrganisationSection{" +
                "listField=" + listField +
                '}';
    }
}
