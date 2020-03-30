package com.base_java.webapp.model;

import java.util.Objects;

public class TextField extends AbstractSection {
    protected String textField;

    public TextField(String textField) {
        this.textField = textField;
    }

    public String getTextField() {
        return textField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextField textField1 = (TextField) o;
        return textField.equals(textField1.textField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textField);
    }

    @Override
    public String toString() {
        return "TextField{" +
                "textField='" + textField + '\'' +
                '}';
    }
}
