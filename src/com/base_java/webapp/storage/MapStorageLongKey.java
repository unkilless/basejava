package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageLongKey extends AbstractStorage {
    protected static final int NOT_FOUNDED = -1;
    protected Map<String, Resume> resumesMapStorageLongKey = new HashMap<>();

    @Override
    protected List<Resume> convertToListStorage() {
        List<Resume> outputSortedList = new ArrayList<>(resumesMapStorageLongKey.values());
        return outputSortedList;
    }

    @Override
    protected Integer searchIndex(Object id) {
        if (resumesMapStorageLongKey.containsKey(id.toString()) == true) {
            return (Integer) id;
        } else
            return NOT_FOUNDED;
    }

    @Override
    protected void setCurrentResume(Object id, Resume resumeForUpd) {
        resumesMapStorageLongKey.put(id.toString(), resumeForUpd);
    }

    @Override
    protected void saveCurrentResume(Object id, Resume savingResume) {
        Integer bufferedId = savingResume.getId();
        resumesMapStorageLongKey.put(bufferedId.toString(), savingResume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return resumesMapStorageLongKey.get(index.toString());
    }

    @Override
    protected void deleteFindedResume(int index) {
        Integer bufferedId = index;
        resumesMapStorageLongKey.remove(bufferedId.toString());
    }

    @Override
    public int sizeOfArray() {
        return resumesMapStorageLongKey.size();
    }

    @Override
    public void deleteAll() {
        resumesMapStorageLongKey.clear();
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }
}
