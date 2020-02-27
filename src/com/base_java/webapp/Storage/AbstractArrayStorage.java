package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int RESUME_NOT_FOUND = -1;
    protected static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    protected static final int MAX_LENGTH = 10000;
    public Resume[] resumes = new Resume[MAX_LENGTH];
    protected static int size = 0;

    public int sizeOfArray() {
        return size;
    }

    public void update(Resume resumeForUpd) {
        int index = getIndex(resumeForUpd.getId());
        if (index != RESUME_NOT_FOUND) {
            resumes[index].setFullName(resumeForUpd.getFullName());
            logger.info("Resume updated.");
        } else logger.info("Not found.");
    }

    public Resume getByID(Integer ID) {
        Integer index = getIndex(ID);
        if (!index.equals(RESUME_NOT_FOUND)) {
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
}

