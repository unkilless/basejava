package com.base_java.webapp;

import com.base_java.webapp.Model.Resume;
import com.base_java.webapp.Storage.ArrayStorage;

public class MainTestArrayStorage {

    public static void main(String[] args) {
        ArrayStorage myArray = new ArrayStorage();
        Resume newResumeRecord = new Resume("Ivan", 29);
        myArray.save(newResumeRecord);

        Resume outResumeRecord;
        outResumeRecord = myArray.getByID(29);
        System.out.println(outResumeRecord.getFullName() + " by " + outResumeRecord.getId());
    }
}
