package com.base_java.webapp;

import com.base_java.webapp.Model.Resume;
import com.base_java.webapp.Storage.ArrayStorage;

import java.util.Arrays;

public class MainTestArrayStorage {

    public static final ArrayStorage myArray = new ArrayStorage();

    public static void main(String[] args) {
        Resume newResumeRecord = new Resume("Ivan", 29);
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
        System.out.println();
    }
}
