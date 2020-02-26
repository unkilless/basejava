package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void update(Resume resumeForUpd) {
        int index = getIndex(resumeForUpd.getId());
        if (index != RESUME_NOT_FOUND) {
            resumes[index].setFullName(resumeForUpd.getFullName());
            logger.info("Resume updated.");
        } else logger.info("Not found.");
    }

    protected Integer getIndex(Integer findingId) {
        for (int i = 0; i < size; i++) {
            if (findingId.equals(resumes[i].getId()))
                return i;
        }
        return RESUME_NOT_FOUND;
    }


    public void save(Resume savingResume) {
        Integer index = getIndex(savingResume.getId());
        if (size < MAX_LENGTH - 1 && index.equals(RESUME_NOT_FOUND)) {
            resumes[size] = savingResume;
            logger.info("Резюме создано: " + resumes[size].getFullName());
            size++;
        } else logger.info("Resume not saved. Check size your storage or your new resume record has equal ID.");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(resumes, size);
    }

    public void deleteByID(Integer ID) {
        Integer index = getIndex(ID);
        if (!index.equals(RESUME_NOT_FOUND)) {
            resumes[index] = resumes[size - 1];
            resumes[size - 1] = null;
            size--;
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else logger.info("Resume not founded.");
    }

    public void deleteAll() {
        for (int i = 0; i < size; i++) {
            resumes[i] = null;
        }
        //Arrays.fill(resumes, null);
        size = 0;
    }

    public int getIdByValue(String findingStr) {
        for (int i = 0; i < size; i++) {
            if (resumes[i].getFullName() == findingStr)
                return resumes[i].getId();
        }
        return RESUME_NOT_FOUND;
    }

}
