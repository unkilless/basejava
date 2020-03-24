package com.base_java.webapp.model;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
    private Integer id;
    private String fullName;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
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
