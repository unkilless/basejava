package com.base_java.webapp.storage;

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
        if (index > FLAG_FOUNDED) {
            resumes[index].setFullName(resumeForUpd.getFullName());
            logger.info("Resume updated.");
        } else logger.info("Not found.");
    }

    public Resume getByID(Integer ID) {
        Integer index = getIndex(ID);
        if (index > FLAG_FOUNDED) {
            if (ID.equals(resumes[index].getId()))
                return resumes[index];
        }
        return null;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(resumes, size);
    }

    public void deleteAll() {
        Arrays.fill(resumes, null);
        size = 0;
    }

    protected abstract Integer getIndex(Integer id);

    public abstract int[] getIdByValue(String findingStr);

    public void save(Resume savingResume) {
        Integer index = getIndex(savingResume.getId());
        if (size < MAX_LENGTH - 1 && index < 0) {
            insertElement(savingResume, index);
            logger.info("Резюме создано: " + resumes[size].getFullName());
            size++;
        } else logger.info("Resume not saved. Check size your storage or your new resume record has equal ID.");
    }

    public abstract void insertElement (Resume savingResume, Integer index);

    public void deleteByID(Integer ID) {
        Integer index = getIndex(ID);
        if (index > FLAG_FOUNDED) {
            fillDeleteElement(index);
            size--;
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else logger.info("Resume not founded.");
    }

    public abstract void fillDeleteElement(Integer index);
}

