package com.base_java.webapp;

import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.ArrayStorage;
import com.base_java.webapp.storage.SortedArrayStorage;

public class MainTestArrayStorage {

    public static final ArrayStorage myArray = new ArrayStorage();

    public static final SortedArrayStorage sortedArray = new SortedArrayStorage();

    public static void main(String[] args) {

        Resume newSortResumeRecord = new Resume("Ivan", 29);
        sortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("gena", 199);
        sortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("sanya", 69);
        sortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("jopa", 79);
        sortedArray.save(newSortResumeRecord);

        newSortResumeRecord = new Resume();
        sortedArray.save(newSortResumeRecord);

        for (int i = 0; i < sortedArray.sizeOfArray(); i++)
            System.out.println("ID: " + sortedArray.resumes[i].getId() + "; Name: " + sortedArray.resumes[i].getFullName() + ";");

    }
}
