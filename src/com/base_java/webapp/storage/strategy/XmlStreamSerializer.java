package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.Util.XmlParser;
import com.base_java.webapp.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStreamSerializer implements AbstractStrategy {
    private XmlParser xmlParser;

    public XmlStreamSerializer() {
        xmlParser = new XmlParser(
                Resume.class, Organization.class, UrlField.class,
                OrganisationSection.class, TextField.class, ListField.class, Organization.Position.class, Contact.class, ContactType.class);
    }

    @Override
    public void writeResume (Resume r, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, w);
        }
    }

    @Override
    public Resume readResume (InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }
}
