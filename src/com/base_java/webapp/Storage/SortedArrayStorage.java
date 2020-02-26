package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    public void update(Resume resumeForUpd) {

    }

    @Override
    public void save(Resume savingResume) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public void deleteByID(Integer ID) {

    }

    @Override
    protected Integer getIndex(Integer id) {
        Resume searchKey = new Resume("", id);
        return Arrays.binarySearch(resumes, 0, size, searchKey);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int getIdByValue(String findingStr) {
        return 0;
    }
}
