package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.Util.JsonParser;
import com.base_java.webapp.model.Resume;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonStreamSerializer implements AbstractStrategy {

    @Override
    public void writeResume (Resume r, OutputStream os) throws IOException {
        try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            JsonParser.write(r, writer);
        }
    }

    @Override
    public Resume readResume (InputStream is) throws IOException {
        try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return JsonParser.read(reader, Resume.class);
        }
    }
}
