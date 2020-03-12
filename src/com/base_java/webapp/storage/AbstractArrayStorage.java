package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int RESUME_NOT_FOUND = -1;
    protected static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    protected static final int MAX_LENGTH = 10000;
    public Resume[] resumes = new Resume[MAX_LENGTH];
    protected int size = 0;

    public int sizeOfArray() {
        return size;
    }

    public void save(Resume savingResume) {
        Integer index = searchIndex(savingResume.getId());
        if (size < MAX_LENGTH) {
            if (index < 0) {
                insertElement(savingResume, index);
                logger.info("Резюме создано: " + savingResume.getFullName());
                size++;
            } else {
                logger.info("Resume not saved. Your new resume record has equal ID.");
                throw new ExistStorageException(savingResume.getId());
            }
        } else {
            logger.info("Resume not saved. Check size your storage length. Invalid resume ID: " + savingResume.getId());
            throw new StorageOverflow(savingResume.getId());
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(resumes, size);
    }

    public void deleteAll() {
        Arrays.fill(resumes, null);
        size = 0;
    }

    protected void setCurrentResume(Integer index, Resume resumeForUpd) {
        resumes[index].setFullName(resumeForUpd.getFullName());
    }

    protected abstract Integer searchIndex(Integer id);

    protected  Resume getResume(Integer index){
        return resumes[index];
    }

    protected void deleteFindedResume (int index){
        fillDeleteElement(index);
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

    public abstract void insertElement(Resume savingResume, Integer index);

    public abstract void fillDeleteElement(Integer index);
}

