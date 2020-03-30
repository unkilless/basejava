package com.base_java.webapp.model;

import java.net.URL;

public class UrlField extends AbstractSection {
    private URL link;

    public UrlField(URL link) {
        this.link = link;
    }

    public URL getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "UrlField{" +
                "link=" + link +
                '}';
    }
}
