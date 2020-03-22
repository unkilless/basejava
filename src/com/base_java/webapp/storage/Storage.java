package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.List;

public interface Storage {

    int sizeOfArray();

    void update(Resume resumeForUpd);

    void save(Resume savingResume);

    List<Resume> getAllSorted();

    Resume getByID(Integer ID);

    void deleteByID(Integer ID);

    void deleteAll();

    int[] getIdByValue(String findingStr);
}
