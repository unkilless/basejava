package com.base_java.webapp.storage;

import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.model.Resume;

import java.util.logging.Logger;

public abstract class AbstractStorage implements Storage {
    protected static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    protected Resume resume;
    protected int size = 0;

    public abstract int sizeOfArray();

    public void update(Resume resumeForUpd) {
        Integer index = searchIndex(resumeForUpd.getId());
        if (index >= 0) {
            setCurrentResume(index, resumeForUpd);
            logger.info("Resume updated.");
        } else {
            logger.info("Not found.");
            throw new NotExistStorageException(resumeForUpd.getId());
        }
    }

    public abstract void save(Resume savingResume);

    public abstract Resume[] getAll();

    public Resume getByID(Integer ID) {
        Integer index = searchIndex(ID);
        if (index >= 0) {
            if (ID.equals(getResume(index).getId()))
                return getResume(index);
        }
        return null;
    }

    public abstract void deleteAll();

    public void deleteByID(Integer ID) {
        Integer index = searchIndex(ID);
        if (index >= 0) {
            deleteFindedResume(index);
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else {
            logger.info("Resume not founded.");
            throw new NotExistStorageException(ID);
        }
    }

    protected abstract Integer searchIndex(Integer id);

    protected abstract void setCurrentResume(Integer id, Resume resumeForUpd);

    protected  abstract Resume getResume(Integer index);

    protected abstract void deleteFindedResume (int index);

}
