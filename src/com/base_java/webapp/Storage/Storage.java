package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

public interface Storage {

    int sizeOfArray();

    void update(Resume resumeForUpd);

    void save(Resume savingResume);

    Resume[] getAll();

    Resume getByID(Integer ID);

    void deleteByID(Integer ID);

    void deleteAll();

    int getIdByValue(String findingStr);
}
