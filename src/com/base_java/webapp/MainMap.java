package com.base_java.webapp;

import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.MapStorage;
import com.base_java.webapp.storage.Storage;

public class MainMap {
    public static void main(String[] args) {
        Storage mapStorage = new MapStorage();

        mapStorage.save(new Resume("Iban", 37));
        mapStorage.save(new Resume("Gena", 77));
        mapStorage.save(new Resume("Vadim", 83));

        System.out.println("Size of DB: " + mapStorage.sizeOfArray() + "\nResumes: ");
        Resume[] outputResumes;
        outputResumes = mapStorage.getAll();
        for (int i = 0; i < mapStorage.sizeOfArray(); i++){
            System.out.println(outputResumes[i]);
        }

        System.out.println("Get resume by ID = 83: " + mapStorage.getByID(83));
        System.out.println("Get resume by ID = 37: " + mapStorage.getByID(37));

        mapStorage.deleteByID(37);

        mapStorage.update(new Resume("Gennadi", 77));

        outputResumes = mapStorage.getAll();
        for(int i = 0; i < mapStorage.sizeOfArray(); i++){
            System.out.println(outputResumes[i]);
        }

        mapStorage.deleteAll();

        System.out.println(mapStorage.sizeOfArray());
    }
}
