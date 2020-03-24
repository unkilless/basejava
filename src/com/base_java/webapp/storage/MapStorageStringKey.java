package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageStringKey extends AbstractStorage {
    protected static final int NOT_FOUNDED = -1;
    protected Map<String, Resume> resumesMapStorageStringKey = new HashMap<>();

    @Override
    protected List<Resume> convertToListStorage() {
        List<Resume> outputSortedList = new ArrayList<>(resumesMapStorageStringKey.values());
        return outputSortedList;
    }

    @Override
    protected Integer searchKey(Object id) {
        return (Integer) id;
    }

    @Override
    protected void setCurrentResume(Object id, Resume resumeForUpd) {
        resumesMapStorageStringKey.put(id.toString(), resumeForUpd);
    }

    @Override
    protected void saveCurrentResume(Object id, Resume savingResume) {
        Integer bufferedId = savingResume.getId();
        resumesMapStorageStringKey.put(bufferedId.toString(), savingResume);
    }

    @Override
    protected Resume getResume(Object index) {
        return resumesMapStorageStringKey.get(index.toString());
    }

    @Override
    protected void deleteFindedResume(Object index) {
        Integer bufferedId = (Integer) index;
        resumesMapStorageStringKey.remove(bufferedId.toString());
    }

    @Override
    public int sizeOfArray() {
        return resumesMapStorageStringKey.size();
    }

    @Override
    public void deleteAll() {
        resumesMapStorageStringKey.clear();
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }

    protected boolean isExist(Object index) {
        return resumesMapStorageStringKey.containsKey(index.toString());
    }
}
