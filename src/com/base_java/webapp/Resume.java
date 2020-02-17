package com.base_java.webapp;

public class Resume {
    private static int counter = 0;
    private int id = counter++;
    private String fullName;

    public Resume(String fullName) {
        this.fullName = fullName;
    }

    public Resume(String fullName, int id) {
        this.fullName = fullName;
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


}
