package com.base_java.webapp;

import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.ListStorage;

public class MainArrayList {


    public static void main(String[] args) {
        ListStorage listStorage = new ListStorage();

        System.out.println(listStorage.sizeOfArray());

        try {
            listStorage.update(new Resume("Iban", 67));
        } catch (NotExistStorageException e) {
            System.out.println("Record not exist");
        }

        listStorage.save(new Resume("Iban", 11));
        listStorage.save(new Resume("GENA", 777));
        listStorage.save(new Resume("Feodor", 65));

        listStorage.update(new Resume("Jopa", 11));

        System.out.println("U wanna " + listStorage.getByID(11) + " ?");

        listStorage.deleteByID(11);

        Resume[] outputResumes = listStorage.getAll();
        for (int i = 0; i < listStorage.sizeOfArray(); i++)
            System.out.println(" - " + outputResumes[i]);

        //listStorage.deleteAll(); //checked

        System.out.println(listStorage.sizeOfArray());

    }

}

