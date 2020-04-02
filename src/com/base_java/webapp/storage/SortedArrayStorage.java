package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    public static final Comparator<Resume> SORTED_RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            if (o1.getId() == o2.getId()) return 0;
            if (o1.getId() > o2.getId()) return 1;
            return -1;
        }
    };

    @Override
    public void insertElement(Resume savingResume, Integer index) {
        Integer countInsertIndex = -index - 1;
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
    protected Integer getSearchKey(Integer id) {
        Resume searchKey = new Resume("", (Integer) id);
        return Arrays.binarySearch(resumes, 0, size, searchKey, SORTED_RESUME_COMPARATOR);
    }

}
