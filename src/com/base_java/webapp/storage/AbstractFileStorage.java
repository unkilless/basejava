package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.io.File;
import java.util.List;
import java.util.Objects;


public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected List<Resume> convertToListStorage() {
        return null;
    }

    @Override
    protected File searchKey(Integer id) {
        return null;
    }

    @Override
    protected void setCurrentResume(File id, Resume resumeForUpd) {

    }

    @Override
    protected void saveCurrentResume(File id, Resume savingResume) {

    }

    @Override
    protected Resume getResume(File index) {
        return null;
    }

    @Override
    protected void deleteFindedResume(File index) {

    }

    @Override
    protected boolean isExist(File index) {
        return false;
    }

    @Override
    public int sizeOfArray() {
        return 0;
    }

    @Override
    public void deleteAll() {

    }
}