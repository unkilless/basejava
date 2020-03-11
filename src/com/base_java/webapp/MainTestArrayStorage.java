package com.base_java.webapp;

import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.ArrayStorage;
import com.base_java.webapp.storage.SortedArrayStorage;

public class MainTestArrayStorage {

    public static final ArrayStorage myArray = new ArrayStorage();

    public static final SortedArrayStorage mySortedArray = new SortedArrayStorage();

    public static void main(String[] args) {

        Resume newSortResumeRecord = new Resume("Ivan", 29);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("gena", 199);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("sanya", 69);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("jopa", 79);
        mySortedArray.save(newSortResumeRecord);

        newSortResumeRecord = new Resume();
        mySortedArray.save(newSortResumeRecord);

        for (int i = 0; i < mySortedArray.sizeOfArray(); i++)
            System.out.println("ID: " + mySortedArray.resumes[i].getId() + "; Name: " + mySortedArray.resumes[i].getFullName() + ";");

    }
}
