package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    protected static final int NOT_FOUNDED = -1;
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
    protected Integer searchKey(Object id) {
        return (Integer) id;
    }

    protected boolean isExist(Object index) {
        return resumesMap.containsKey((Integer) index);
    }

    @Override
    protected void setCurrentResume(Object id, Resume resumeForUpd) {
        resumesMap.put((Integer) id, resumeForUpd);
    }

    @Override
    protected void saveCurrentResume(Object id, Resume savingResume) {
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
