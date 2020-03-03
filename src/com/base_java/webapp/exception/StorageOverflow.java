package com.base_java.webapp.exception;

public class StorageOverflow extends StorageException {
    public StorageOverflow(int id) {
        super("Count of storage resumes more than MAX_LENGTH. Can't create resume with id: " + id, id);
    }
}
