package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected Integer searchIndex(Integer findingId) {
        for (int i = 0; i < size; i++) {
            if (findingId.equals(resumes[i].getId()))
                return i;
        }
        return RESUME_NOT_FOUND;
    }

    public void insertElement(Resume savingResume, Integer index){
        resumes[size] = savingResume;
    }

    @Override
    public void fillDeleteElement(Integer index) {
        resumes[index] = resumes[size - 1];
        resumes[size - 1] = null;
    }

}
