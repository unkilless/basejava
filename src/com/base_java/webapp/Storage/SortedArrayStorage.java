package com.base_java.webapp.Storage;

import com.base_java.webapp.Model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void insertElement(Resume savingResume, Integer index) {
        Integer countInsertIndex = - index - 1;
        System.arraycopy(resumes, countInsertIndex, resumes, countInsertIndex + 1, size - countInsertIndex);
        resumes[countInsertIndex] = savingResume;
    }

    @Override
    public void fillDeleteElement(Integer index) {
        Integer posForCopy = size - index - 1;
        if (posForCopy > 0)
            System.arraycopy(resumes, posForCopy + 1, resumes, posForCopy, size - posForCopy - 1);
    }

    @Override
    protected Integer getIndex(Integer id) {
        Resume searchKey = new Resume("", id);
        return Arrays.binarySearch(resumes, 0, size, searchKey);
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return null;
    }
}
