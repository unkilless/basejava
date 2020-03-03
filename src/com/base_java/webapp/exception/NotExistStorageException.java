package com.base_java.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(int id) {
        super("Resume with id: " + id + " not exist", id);
    }
}
