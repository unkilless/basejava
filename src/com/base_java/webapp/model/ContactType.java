package com.base_java.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    EMAIL("Мыло"),
    SKYPE ("Скайп"),
    PROFILES ("Профили во всякой херне"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
