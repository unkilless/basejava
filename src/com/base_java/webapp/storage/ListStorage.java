package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;

public class ListStorage extends AbstractStorage {

    protected static final int EMPTY_LIST = 0;
    protected static final int NOT_FOUNDED = -1;
    protected ArrayList<Resume> resumesList = new ArrayList<>();

    public ListStorage() {
    }

    public int sizeOfArray() {
        try {
            return resumesList.size();
        } catch (NullPointerException e) {
            return EMPTY_LIST;
        }
    }

    public void save(Resume savingResume) {
        Integer index = searchIndex(savingResume.getId());
            if (index < 0) {
                resumesList.add(savingResume);
                logger.info("Резюме создано: " + savingResume.getFullName());
            } else {
                logger.info("Resume not saved. Your new resume record has equal ID.");
                throw new ExistStorageException(savingResume.getId());
            }
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public Resume getByID(Integer ID) {
        return null;
    }

    @Override
    public void deleteByID(Integer ID) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }

    protected Integer searchIndex(Integer id){
        try {
           Integer counter = 0;
           Iterator<Resume> it = resumesList.iterator();
           while (it.hasNext()){
               if (id.equals(it.next().getId()))
                   return counter;
               counter++;
               //it.next();
           }
           return NOT_FOUNDED;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return NOT_FOUNDED;
        }
    }

    protected void setCurrentResume(Integer id, Resume resumeForUpd){
        resumesList.set(id, resumeForUpd);
    }
}
