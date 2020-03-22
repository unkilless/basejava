package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public abstract class CommonTest {
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

    public static final String FOURTH_NAME = "Georgy";
    public static final int FOURTH_ID = 77;

    public CommonTest(Storage storage) {
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
    void updateIncorrect() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.update(new Resume(FOURTH_NAME, FOURTH_ID));
        });

    }

    @Test
    void updateCorrect() {
        storage.update(new Resume(FOURTH_NAME, SECOND_ID));
        Assertions.assertEquals(storage.getByID(SECOND_ID).getFullName(), FOURTH_NAME);
    }

    @Test
    void saveIncorrect() {
        Assertions.assertThrows(ExistStorageException.class, () -> {
            storage.save(new Resume(SECOND_NAME, THIRD_ID));
        });
    }

    @Test
    void saveCorrect() {
        String newStr = "testName";
        int newId = 90;

        storage.save(new Resume(newStr, newId));
    }

    @Test
    void checkCorrectSize() {
        for (int i = 0; i < MAX_LENGTH - 3; i++) {
            storage.save(new Resume("TestCharset", i + 100));
            System.out.println("counter - " + i);
        }
        System.out.println("Entered resumes - " + storage.sizeOfArray());
        String nameOfClass = storage.getClass().getName().toLowerCase();
        if (!nameOfClass.contains("list") && !nameOfClass.contains("map")) {
            Assertions.assertThrows(StorageOverflow.class, () -> {
                storage.save(new Resume("lastFullName", 25000));
            });
        }
    }


    @Test
    void getAll() {
        List<Resume> testResumesList = storage.getAllSorted();
        Assertions.assertEquals(testResumesList.get(0), FIRST_RESUME);
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
    void deleteByIDIncorrect() {
        int incorrectId = 90;
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.deleteByID(incorrectId);
        });
    }

    @Test
    void deleteByIDCorrect() {
        storage.deleteByID(SECOND_ID);
        Assertions.assertEquals(2, storage.sizeOfArray());
    }

    @Test
    void getIdByValue() {
        int[] testIntArray = storage.getIdByValue(SECOND_NAME);
    }
}