package com.base_java.webapp;

public class Resume {
    private static int counter = 0;
    private int id;
    private String fullName;

    public Resume(String fullName) {
        this.fullName = fullName;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
