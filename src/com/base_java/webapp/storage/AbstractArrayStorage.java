package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int RESUME_NOT_FOUND = -1;
    protected static final int FLAG_FOUNDED = 0;
    protected static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    protected static final int MAX_LENGTH = 10000;
    public Resume[] resumes = new Resume[MAX_LENGTH];
    protected static int size = 0;

    public int sizeOfArray() {
        return size;
    }

    public void update(Resume resumeForUpd) {
        int index = getIndex(resumeForUpd.getId());
        if (index >= 0) {
            resumes[index].setFullName(resumeForUpd.getFullName());
            logger.info("Resume updated.");
        } else {
            logger.info("Not found.");
            throw new NotExistStorageException(resumeForUpd.getId());
        }
    }

    public void save(Resume savingResume) {
        Integer index = getIndex(savingResume.getId());
        if (size < MAX_LENGTH - 1) {
            if (index < 0) {
                insertElement(savingResume, index);
                logger.info("Резюме создано: " + resumes[size].getFullName());
                size++;
            } else {
                logger.info("Resume not saved. Your new resume record has equal ID.");
                throw new ExistStorageException(savingResume.getId());
            }
        } else {
            logger.info("Resume not saved. Check size your storage length.");
            throw new StorageOverflow(savingResume.getId());
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(resumes, size);
    }

    public Resume getByID(Integer ID) {
        Integer index = getIndex(ID);
        if (index >= 0) {
            if (ID.equals(resumes[index].getId()))
                return resumes[index];
        }
        return null;
    }

    public void deleteAll() {
        Arrays.fill(resumes, null);
        size = 0;
    }

    public void deleteByID(Integer ID) {
        Integer index = getIndex(ID);
        if (index > FLAG_FOUNDED) {
            fillDeleteElement(index);
            size--;
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else {
            logger.info("Resume not founded.");
            throw new NotExistStorageException(ID);
        }
    }

    public abstract int[] getIdByValue(String findingStr);

    protected abstract Integer getIndex(Integer id);

    public abstract void insertElement(Resume savingResume, Integer index);

    public abstract void fillDeleteElement(Integer index);
}

