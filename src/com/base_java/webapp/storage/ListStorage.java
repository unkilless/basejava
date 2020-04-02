package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

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

    public void doSave(Integer id, Resume savingResume) {
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

    protected Integer getSearchKey(Integer id){
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

    protected void doUpdate(Integer id, Resume resumeForUpd){
        resumesList.set(id, resumeForUpd);
    }

    @Override
    protected Resume doGet(Integer index) {
        return resumesList.get(index);
    }

    protected void doDelete(Integer index) {
        resumesList.remove(index.intValue());
    };

    protected boolean isExist(Integer index) {
        return  index >= 0;
    }
}
