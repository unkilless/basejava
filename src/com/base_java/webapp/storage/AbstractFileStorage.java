package com.base_java.webapp.storage;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
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
        File[] listFiles = directory.listFiles();
        List<Resume> resumesList = Collections.emptyList();
        if (listFiles == null){
            throw new StorageException("Empty directory", 0);
        }
        else{
            for(File readableFile: listFiles){
                try {
                    resumesList.add(doRead(readableFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resumesList;
    }

    @Override
    protected File getSearchKey(Integer file) {
        return new File(directory, file.toString());
    }

    @Override
    protected void doUpdate(File file, Resume resumeForUpd) {
        try {
            doWrite(resumeForUpd, file);
        } catch (IOException e) {
            throw new StorageException("Can't update resume", resumeForUpd.getId());
        }
    }

    @Override
    protected void doSave(File file, Resume savingResume) {
        try {
            doWrite(savingResume, file);
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Can't create file", savingResume.getId());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    public int sizeOfArray() {
        String[] listFiles = directory.list();
        if (listFiles == null) {
            throw new StorageException("No founded resumes", 0);
        }
        return listFiles.length;
    }

    @Override
    public void deleteAll() {
        File[] listFiles = directory.listFiles();
        if (listFiles != null){
            for(File deletedFile: listFiles){
                deletedFile.delete();
            }
        }
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;
    protected abstract Resume doRead(File file) throws IOException;
}