package com.base_java.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListField extends AbstractSection {
    protected List<String> listField;

    public ListField(List<String> listField) {
        this.listField = listField;
    }

    public List<String> getListField() {
        return listField;
    }

    @Override
    public String toString() {
        return "ListField{" +
                "listField=" + listField +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListField listField1 = (ListField) o;
        return Objects.equals(listField, listField1.listField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listField);
    }

}
