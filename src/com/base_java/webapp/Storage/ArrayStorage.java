package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

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

    public void deleteByID(Integer ID) {
        Integer index = getIndex(ID);
        if (!index.equals(RESUME_NOT_FOUND)) {
            resumes[index] = resumes[size - 1];
            resumes[size - 1] = null;
            size--;
            logger.info("Resume with ID: " + ID.toString() + " was deleted.");
        } else logger.info("Resume not founded.");
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

}
