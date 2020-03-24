package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<Integer> {

    protected Map<Integer, Resume> resumesMap = new HashMap<Integer, Resume>();

    @Override
    public int sizeOfArray() {
        return resumesMap.size();
    }

    @Override
    protected List<Resume> convertToListStorage() {
        List<Resume> outputSortedList = new ArrayList<Resume>(resumesMap.values());
        return outputSortedList;
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
    protected Integer searchKey(Integer id) {
        return id;
    }

    protected boolean isExist(Integer index) {
        return resumesMap.containsKey(index);
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
    protected void deleteFindedResume(Integer index) {
        resumesMap.remove(index);
    }
}
