package com.base_java.webapp.model;

import java.util.Objects;

public class Contact {
    private String contact;

    public Contact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contact='" + contact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact1 = (Contact) o;
        return Objects.equals(contact, contact1.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }
}
