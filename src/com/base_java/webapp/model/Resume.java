package com.base_java.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fullName;
    private Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);
    private Map<ContactType, Contact> contacts = new EnumMap<>(ContactType.class);

    public Resume() {
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
        if (Objects.equals(id, resume.id))
            System.out.println("true");
        if(Objects.equals(fullName, resume.fullName))
            System.out.println("true");
        if(Objects.equals(contacts, resume.contacts))
            System.out.println("true");
        if(Objects.equals(sections, resume.sections))
            System.out.println("true");
        return Objects.equals(id, resume.id) &&
                Objects.equals(fullName, resume.fullName) &&
                //Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, sections, contacts);
    }

    @Override
    public int compareTo(Resume o) {
        return Comparator.comparing(Resume::getId)
                .thenComparing(Resume::getFullName)
                .compare(this, o);
//        return this.id.compareTo(o.id); //оставил как наиболее подходещее условие сравнения
    }

}
