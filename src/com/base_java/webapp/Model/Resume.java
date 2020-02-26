package com.base_java.webapp.Model;

import java.util.Objects;

public class Resume implements Comparable<Resume> {
    private static int counter = 0;
    private Integer id = counter++;
    private String fullName;

    public Resume(String fullName) {
        this.fullName = fullName;
    }

    public Resume(String fullName, int id) {
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
        return id == resume.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Resume o) {
        if (id.equals(o.id)) return 0;
        if (id > o.id) return -1;
        else return 1;
    }
}
