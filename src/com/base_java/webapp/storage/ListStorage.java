package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected static final int EMPTY_LIST = 0;
    protected static final int NOT_FOUNDED = -1;
    protected List<Resume> resumesList = new ArrayList<>();

    public int sizeOfArray() {
        try {
            return resumesList.size();
        } catch (NullPointerException e) {
            return EMPTY_LIST;
        }
    }

    public void saveCurrentResume(Object id, Resume savingResume) {
                resumesList.add(savingResume);
    }

    @Override
    protected List<Resume> convertToListStorage() {
        return resumesList;
    }

    @Override
    public void deleteAll() {
        resumesList.clear();
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }

    protected Integer searchIndex(Object id){
        try {
           Integer counter = 0;
           Iterator<Resume> it = resumesList.iterator();
           while (it.hasNext()){
               if (id.equals(it.next().getId()))
                   return counter;
               counter++;
           }
           return NOT_FOUNDED;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return NOT_FOUNDED;
        }
    }

    protected void setCurrentResume(Object id, Resume resumeForUpd){
        resumesList.set((Integer) id, resumeForUpd);
    }

    @Override
    protected Resume getResume(Integer index) {
        return resumesList.get(index);
    }

    protected void deleteFindedResume (int index) {
        resumesList.remove(index);
    };

    protected boolean isExist(Object index) {
        return  (Integer) index >= 0;
    }
}
