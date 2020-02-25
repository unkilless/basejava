package com.base_java.webapp;

import java.util.Arrays;
import java.util.logging.Logger;

public class ArrayStorage {
    private static final int RESUME_NOT_FOUND = -1;
    private static Logger logger = Logger.getLogger(ArrayStorage.class.getName());
    static int MAX_LENGHT = 10000;
    private Resume[] resumes = new Resume[MAX_LENGHT];

    private static int size = 0;

    public int sizeOfArray() {
        return size;
    }

    public void update(Resume resumeForUpd) {
        int index = find(resumeForUpd.getId());
        if (index != RESUME_NOT_FOUND) {
            resumes[index].setFullName(resumeForUpd.getFullName());
        }
    }

    public int find(Integer findingId) {
        for (int i = 0; i < size; i++) {
            if (findingId.equals(resumes[i].getId()))
                return i;
        }
        return -1;
    }


    public void save(Resume savingResume) {
        if (size < MAX_LENGHT - 1 && find(savingResume.getId()) == -1) {
            resumes[size] = savingResume;
            logger.info("Резюме создано: " + resumes[size].getFullName());
            size++;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(resumes, size);
    }

    public Resume getByID(Integer ID) {
        Integer index = find(ID);
        if (index != -1) {
            if (ID.equals(resumes[index].getId()))
                return resumes[index];
        }
        return null;
    }

    public void deleteByID(Integer ID) {
        Integer index = find(ID);
            if (index != -1) {
                resumes[index] = resumes[size - 1];
                resumes[size - 1] = null;
                size--;
            }

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
        return -1;
    }

}
