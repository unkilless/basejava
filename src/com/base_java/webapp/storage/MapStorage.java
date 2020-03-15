package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected static final int EMPTY_LIST = 0;
    protected static final int NOT_FOUNDED = -1;
    protected Map<Integer, Resume> resumesMap = new HashMap<>();

    @Override
    public int sizeOfArray() {
        return resumesMap.size();
    }

    @Override
    public Resume[] getAll() {
        int i = 0;
        Resume[] resumes = new Resume[resumesMap.size()];
        for (Resume resume: resumesMap.values()){
            resumes[i++] = resume;
        }
        return resumes;
    }

    @Override
    public void deleteAll() {
        resumesMap.clear();
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }

    @Override
    protected Integer searchIndex(Integer id) {
        if (resumesMap.containsKey(id) == true) {
            return id;
        } else
            return NOT_FOUNDED;
    }

    @Override
    protected void setCurrentResume(Integer id, Resume resumeForUpd) {
        resumesMap.put(id, resumeForUpd);
    }

    @Override
    protected void saveCurrentResume(Integer id, Resume savingResume) {
        resumesMap.put(savingResume.getId(), savingResume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return resumesMap.get(index);
    }

    @Override
    protected void deleteFindedResume(int index) {
        resumesMap.remove(index);
    }
}
