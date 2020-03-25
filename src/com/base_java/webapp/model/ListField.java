package com.base_java.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListField extends FieldType {
    protected List<String> listField = new ArrayList<>();

    public ListField(List<String> listField) {
        this.listField = listField;
    }

    public List<String> getListField() {
        return listField;
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
