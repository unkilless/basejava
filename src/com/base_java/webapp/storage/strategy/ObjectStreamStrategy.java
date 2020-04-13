package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.Resume;

import java.io.*;

public class ObjectStreamStrategy implements AbstractStrategy {
    @Override
    public void writeResume(Resume resume, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    public Resume readResume(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            Resume r = (Resume) ois.readObject();
            return r;
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", 0);
        }
    }
}
