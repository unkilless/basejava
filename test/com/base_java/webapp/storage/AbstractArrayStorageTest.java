package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AbstractArrayStorageTest {
    private Storage storage = new ArrayStorage();

    @BeforeAll
    public void setUp() throws Exception {
        storage.deleteAll();
        storage.save(new Resume("Iban", 11));
        storage.save(new Resume("Gena", 22));
        storage.save(new Resume("Ibragim", 31));
        System.out.println(storage.getByID(22));
    }

    @Test
    void sizeOfArray() {

    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByID() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteByID() {
    }

    @Test
    void getIdByValue() {
    }
}