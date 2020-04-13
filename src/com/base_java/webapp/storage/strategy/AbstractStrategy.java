package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface AbstractStrategy {
    void writeResume(Resume resume, OutputStream outputStream) throws IOException;

    Resume readResume(InputStream inputStream) throws IOException;
}
