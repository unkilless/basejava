package com.base_java.webapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapField extends FieldType {
    //KEY == organisation name
    protected Map<String, MapStructValue> mapField = new HashMap<>();

    public MapField(String organisationName, MapStructValue mapValue) {
        this.mapField.put(organisationName, mapValue);
    }

    public Map<String, MapStructValue> getMapField() {
        return mapField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapField mapField1 = (MapField) o;
        return Objects.equals(mapField, mapField1.mapField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapField);
    }

}
