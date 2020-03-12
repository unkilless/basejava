package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

public interface Storage {

    int sizeOfArray();

    void update(Resume resumeForUpd);

    void save(Resume savingResume);

    Object[] getAll();

    Resume getByID(Integer ID);

    void deleteByID(Integer ID);

    void deleteAll();

    int[] getIdByValue(String findingStr);
}
