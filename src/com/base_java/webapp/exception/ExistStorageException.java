package com.base_java.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(int id) {
        super("Resume with id: " + id + " already exist" , id);
    }
}
