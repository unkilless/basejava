package com.base_java.webapp;

import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.ArrayStorage;
import com.base_java.webapp.storage.SortedArrayStorage;

public class MainTestArrayStorage {

    public static final ArrayStorage myArray = new ArrayStorage();

    public static final SortedArrayStorage mySortedArray = new SortedArrayStorage();

    public static void main(String[] args) {
        /*Resume newResumeRecord = new Resume("Ivan", 29);
        myArray.save(newResumeRecord);
        newResumeRecord = new Resume("gena", 66);
        myArray.save(newResumeRecord);
        newResumeRecord = new Resume("sanya", 69);
        myArray.save(newResumeRecord);
        newResumeRecord = new Resume("jopa", 79);
        myArray.save(newResumeRecord);

        Resume searchKey = new Resume("gena", 79);
        System.out.println(Arrays.binarySearch(myArray.resumes, 0, myArray.sizeOfArray(), searchKey));

        Resume outResumeRecord;
        outResumeRecord = myArray.getByID(69);
        System.out.println(outResumeRecord.getFullName() + " by " + outResumeRecord.getId());

        int[] resultGetByValue = new int[myArray.sizeOfArray()];
        resultGetByValue = myArray.getIdByValue("Ivan");
        for (int i : resultGetByValue) {
            if (i != 0)
                System.out.println(i + "; ");
        }
        System.out.println();*/

        Resume newSortResumeRecord = new Resume("Ivan", 29);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("gena", 199);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("sanya", 69);
        mySortedArray.save(newSortResumeRecord);
        newSortResumeRecord = new Resume("jopa", 79);
        mySortedArray.save(newSortResumeRecord);

        for(int i = 0; i < mySortedArray.sizeOfArray(); i++)
            System.out.println("ID: " + mySortedArray.resumes[i].getId() + "; Name: " + mySortedArray.resumes[i].getFullName() + ";");
    }
}
