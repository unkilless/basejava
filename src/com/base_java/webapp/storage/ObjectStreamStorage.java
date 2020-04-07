package com.base_java.webapp.storage;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.Resume;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage {
    protected ObjectStreamStorage(File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume resume, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    protected Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            Resume r = (Resume) ois.readObject();
            return r;
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", 0);
        }
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }
}
