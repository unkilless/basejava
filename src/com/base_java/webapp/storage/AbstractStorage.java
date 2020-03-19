package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.model.Resume;

import java.util.Comparator;
import java.util.logging.Logger;

public abstract class AbstractStorage implements Storage {
    protected static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    protected Resume resume;
    protected int size = 0;

    public static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            if (o1 == null || o2 == null)
                return 1;
            return o1.compareTo(o2);
        }
    };

    public void update(Resume resumeForUpd) {
        Integer index = searchIndex(resumeForUpd.getId());
        if (isExist(index) == true) {
            setCurrentResume(index, resumeForUpd);
            logger.info("Resume updated.");
        } else {
            logger.info("Not found.");
            throw new NotExistStorageException(resumeForUpd.getId());
        }
    }

    public void save(Resume savingResume) {
        Integer index = searchIndex(savingResume.getId());
        if (isExist(index) == false) {
            saveCurrentResume(index, savingResume);
            logger.info("Резюме создано: " + savingResume.getFullName());
        } else {
            logger.info("Resume not saved. Your new resume record has equal ID.");
            throw new ExistStorageException(savingResume.getId());
        }
    }

    public Resume getByID(Integer ID) {
        Integer index = searchIndex(ID);
        if (isExist(index) == true) {
            if (ID.equals(getResume(index).getId()))
                return getResume(index);
        }
        return null;
    }


    public void deleteByID(Integer ID) {
        Integer index = searchIndex(ID);
        if (isExist(index) == true) {
            deleteFindedResume(index);
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else {
            logger.info("Resume not founded.");
            throw new NotExistStorageException(ID);
        }
    }

    protected boolean isExist(Integer index) {
        if (index >= 0) {
            return true;
        } else
            return false;
    }

    protected abstract Integer searchIndex(Integer id);

    protected abstract void setCurrentResume(Integer id, Resume resumeForUpd);

    protected abstract void saveCurrentResume(Integer id, Resume savingResume);

    protected abstract Resume getResume(Integer index);

    protected abstract void deleteFindedResume(int index);

}
