package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractArrayStorageTest {
    //private Storage storage = new ArrayStorage();
    private Storage storage;
    private static final String FIRST_NAME = "Iban";
    public static final int FIRST_ID = 11;
    public static final Resume FIRST_RESUME = new Resume(FIRST_NAME, FIRST_ID);
    public static final String SECOND_NAME = "Gena";
    public static final int SECOND_ID = 22;
    public static final Resume SECOND_RESUME = new Resume(SECOND_NAME, SECOND_ID);
    public static final String THIRD_NAME = "Ibragimn";
    public static final int THIRD_ID = 66;
    public static final Resume THIRD_RESUME = new Resume(THIRD_NAME, THIRD_ID);
    public static final Integer MAX_LENGTH = 10000;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
        storage.deleteAll();
        Assertions.assertEquals(0, storage.sizeOfArray());
        storage.save(FIRST_RESUME);
        storage.save(SECOND_RESUME);
        storage.save(THIRD_RESUME);
    }

    @Test
    void sizeOfArray() {
        Assertions.assertEquals(3, storage.sizeOfArray());


    }

    @Test
    void update() {
        String fourthName = "jopa";
        int fourthId = 77;
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.update(new Resume(fourthName, fourthId));
        });

        storage.update(new Resume(fourthName, SECOND_ID));
        Assertions.assertEquals(storage.getByID(SECOND_ID).getFullName(), fourthName);
    }

    @Test
    void save() {
        String newStr = "testName";
        int newId = 90;

        Assertions.assertThrows(ExistStorageException.class, () -> {
            storage.save(new Resume(SECOND_NAME, THIRD_ID));
        });

        storage.save(new Resume(newStr, newId));

        int currentSize = storage.sizeOfArray();

        for (int i = 0; i < MAX_LENGTH - currentSize; i++) {
            storage.save(new Resume(newStr, i + 100));
        }
        System.out.println(storage.sizeOfArray());

        Assertions.assertThrows(StorageOverflow.class, () -> {
            storage.save(new Resume(newStr, 25000));
        });

    }

    @Test
    void getAll() {
        Resume[] testArrayResumes;
        //testArrayResumes = storage.getAll();
        //Assertions.assertEquals(FIRST_RESUME, testArrayResumes[0]);
        //Assertions.assertEquals(SECOND_RESUME, testArrayResumes[1]);
        //Assertions.assertEquals(THIRD_RESUME, testArrayResumes[2]);
    }

    @Test
    void getByID() {
        int gettingId = 11;
        Resume testResume = storage.getByID(gettingId);
        Assertions.assertEquals(testResume, storage.getByID(gettingId));
    }

    @Test
    void deleteAll() {
        storage.deleteAll();
        Assertions.assertEquals(0, storage.sizeOfArray());
    }

    @Test
    void deleteByID() {
        int incorrectId = 90;
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.deleteByID(incorrectId);
        });
        storage.deleteByID(SECOND_ID);
        Assertions.assertEquals(2, storage.sizeOfArray());
    }

    @Test
    void getIdByValue() {
        int[] testIntArray = storage.getIdByValue(SECOND_NAME);
    }
}