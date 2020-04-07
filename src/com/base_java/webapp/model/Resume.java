package com.base_java.webapp.model;

import java.io.Serializable;
import java.util.*;

public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fullName;
    private Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
    private Map<ContactType, Contact> contacts = new EnumMap<>(ContactType.class);

    public Resume() {
        this.id = (int) (Math.random() * 1000);
        this.fullName = UUID.randomUUID().toString();
    }

    public Resume(String fullName, int id) {
        Objects.requireNonNull(fullName, "FullName can't be empty");
        Objects.requireNonNull(id, "Enter not null and unique ID");
        this.fullName = fullName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public AbstractSection getSections(SectionType sectionType) {
        return sections.get(sectionType);
    }

    public void setSections(SectionType sectionType, AbstractSection section) {
        sections.put(sectionType, section);
    }

    public Contact getContacts(ContactType contactType) {
        return contacts.get(contactType);
    }

    public void setContacts(ContactType contactType, Contact contact) {
        contacts.put(contactType, contact);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return id.equals(resume.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        return Comparator.comparing(Resume::getId)
                .thenComparing(Resume::getFullName)
                .compare(this, o);
//        return this.id.compareTo(o.id); //оставил как наиболее подходещее условие сравнения
    }
}
