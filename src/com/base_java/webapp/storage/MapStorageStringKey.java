package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageStringKey extends AbstractStorage<String> {
    protected Map<String, Resume> resumesMapStorageStringKey = new HashMap<>();

    @Override
    protected List<Resume> convertToListStorage() {
        List<Resume> outputSortedList = new ArrayList<>(resumesMapStorageStringKey.values());
        return outputSortedList;
    }

    @Override
    protected String searchKey(Integer id) {
        return id.toString();
    }

    @Override
    protected void setCurrentResume(String id, Resume resumeForUpd) {
        resumesMapStorageStringKey.put(id, resumeForUpd);
    }

    @Override
    protected void saveCurrentResume(String id, Resume savingResume) {
        Integer bufferedId = savingResume.getId();
        resumesMapStorageStringKey.put(bufferedId.toString(), savingResume);
    }

    @Override
    protected Resume getResume(String index) {
        return resumesMapStorageStringKey.get(index);
    }

    @Override
    protected void deleteFindedResume(String index) {
        resumesMapStorageStringKey.remove(index);
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

    protected boolean isExist(String index) {
        return resumesMapStorageStringKey.containsKey(index);
    }
}
