package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    protected static Logger logger = Logger.getLogger(AbstractStorage.class.getName());
    protected Resume resume;

    public static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.compareTo(o2);
        }
    };

    protected abstract List<Resume> convertToListStorage();

    protected abstract SK getSearchKey(Integer id);

    protected abstract void doUpdate(SK id, Resume resumeForUpd);

    protected abstract void doSave(SK id, Resume savingResume);

    protected abstract Resume doGet(SK index);

    protected abstract void doDelete(SK index);

    public void update(Resume resumeForUpd) {
        SK index = getSearchKey(resumeForUpd.getId());
        if (isExist(index) == true) {
            doUpdate(index, resumeForUpd);
            logger.info("Resume updated.");
        } else {
            logger.info("Not found.");
            throw new NotExistStorageException(resumeForUpd.getId());
        }
    }

    public void save(Resume savingResume) {
        SK index = getSearchKey(savingResume.getId());
        if (isExist(index) == false) {
            doSave(index, savingResume);
            logger.info("Резюме создано: " + savingResume.getFullName());
        } else {
            logger.info("Resume not saved. Your new resume record has equal ID.");
            throw new ExistStorageException(savingResume.getId());
        }
    }

    public Resume getByID(Integer ID) {
        SK index = getSearchKey(ID);
        if (isExist(index) == true) {
            if (ID.equals(doGet(index).getId()))
                return doGet(index);
        }
        return null;
    }


    public void deleteByID(Integer ID) {
        SK index = getSearchKey(ID);
        if (isExist(index) == true) {
            doDelete(index);
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else {
            logger.info("Resume not founded.");
            throw new NotExistStorageException(ID);
        }
    }

    protected abstract boolean isExist(SK index);

    public List<Resume> getAllSorted() {
        List<Resume> outputSortedList = convertToListStorage();
        outputSortedList.sort(RESUME_COMPARATOR);
        return outputSortedList;
    }

}
