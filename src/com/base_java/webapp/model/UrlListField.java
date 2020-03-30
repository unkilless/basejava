package com.base_java.webapp.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UrlListField extends AbstractSection {
    List<URL> urlList = new ArrayList<>();

    public UrlListField(List<URL> urlList) {
        this.urlList = urlList;
    }

    public List<URL> getUrlList() {
        return urlList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlListField that = (UrlListField) o;
        return urlList.equals(that.urlList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlList);
    }

    @Override
    public String toString() {
        return "UrlListField{" +
                "urlList=" + urlList +
                '}';
    }
}
