package com.base_java.webapp.storage;

import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int RESUME_NOT_FOUND = -1;
    protected static Logger logger = Logger.getLogger(AbstractArrayStorage.class.getName());
    protected static final int MAX_LENGTH = 10000;
    public Resume[] resumes = new Resume[MAX_LENGTH];
    protected int size = 0;

    public int sizeOfArray() {
        return size;
    }

    protected List<Resume> convertToListStorage() {
        Resume[] resumes = Arrays.copyOfRange(this.resumes, 0, size);
        return Arrays.asList(resumes);
    }

    public void deleteAll() {
        Arrays.fill(resumes, null);
        size = 0;
    }

    protected void setCurrentResume(Object index, Resume resumeForUpd) {
        resumes[(int) index].setFullName(resumeForUpd.getFullName());
    }

    protected void saveCurrentResume(Object id, Resume savingResume) {
        if (size <= MAX_LENGTH - 1) {
            insertElement(savingResume, (int) id);
            size++;
        } else throw new StorageOverflow(savingResume.getId());
    }

    protected Resume getResume(Object index) {
        return resumes[(Integer) index];
    }

    protected void deleteFindedResume(Object index) {
        fillDeleteElement((Integer) index);
        size--;
    }

    public int[] getIdByValue(String findingStr) {
        int[] outputArrayOfIndexes = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (resumes[i].getFullName().equals(findingStr))
                outputArrayOfIndexes[j++] = resumes[i].getId();
        }
        return outputArrayOfIndexes;
    }

    protected boolean isExist(Object index) {
        if ((Integer) index >= 0) {
            return true;
        } else
            return false;
    }

    public abstract void insertElement(Resume savingResume, Integer index);

    public abstract void fillDeleteElement(Integer index);
}

