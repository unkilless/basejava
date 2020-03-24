package com.base_java.webapp;

import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.MapStorageStringKey;
import com.base_java.webapp.storage.Storage;

import java.util.List;

public class MainMap {
    public static void main(String[] args) {
        //Storage mapStorage = new MapStorage();
        Storage mapStorage = new MapStorageStringKey();

        mapStorage.save(new Resume("Iban", 37));
        mapStorage.save(new Resume("Gena", 77));
        mapStorage.save(new Resume("Vadim", 83));
        mapStorage.save(new Resume("Igor", 1));

        System.out.println("Size of DB: " + mapStorage.sizeOfArray() + "\nResumes: ");
        List<Resume> outputResumes;
        outputResumes = mapStorage.getAllSorted();
        for (Resume resume: outputResumes){
            System.out.println(resume);
        }

        System.out.println("Get resume by ID = 83: " + mapStorage.getByID(83));
        System.out.println("Get resume by ID = 37: " + mapStorage.getByID(37));

        mapStorage.deleteByID(37);

        mapStorage.update(new Resume("Gennadi", 77));

        List<Resume> outputList = mapStorage.getAllSorted();
        for(Resume resume: outputList){
            System.out.println(resume);
        }

        mapStorage.deleteAll();

        System.out.println(mapStorage.sizeOfArray());
    }
}
