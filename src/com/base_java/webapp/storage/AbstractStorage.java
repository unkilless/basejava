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
        int index = searchIndex(resumeForUpd.getId());
        if (index >= 0) {
            //TODO создать в AbstractArrayStorage метод setCurrentResume и поместить в него resumes[index].setFullName(resumeForUpd.getFullName());
            setCurrentResume(index, resumeForUpd);
            logger.info("Resume updated.");
        } else {
            logger.info("Not found.");
            throw new NotExistStorageException(resumeForUpd.getId());
        }
    }

    public abstract void save(Resume savingResume);

    protected abstract Integer searchIndex(Integer id);

    protected abstract void setCurrentResume(Integer id, Resume resumeForUpd);

}
