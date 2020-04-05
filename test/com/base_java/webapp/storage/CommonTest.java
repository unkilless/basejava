package com.base_java.webapp.storage;

import com.base_java.webapp.exception.ExistStorageException;
import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.exception.StorageOverflow;
import com.base_java.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public abstract class CommonTest {
    private Storage storage;

    public CommonTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() throws Exception {
        storage.deleteAll();
        Assertions.assertEquals(0, storage.sizeOfArray());
        storage.save(ResumeTestData.FIRST_RESUME);
        storage.save(ResumeTestData.SECOND_RESUME);
        storage.save(ResumeTestData.THIRD_RESUME);
    }

    @Test
    void sizeOfArray() {
        Assertions.assertEquals(3, storage.sizeOfArray());
    }

    @Test
    void updateIncorrect() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.update(new Resume(ResumeTestData.FOURTH_NAME, ResumeTestData.FOURTH_ID));
        });

    }

    @Test
    void updateCorrect() {
        storage.update(new Resume(ResumeTestData.FOURTH_NAME, ResumeTestData.SECOND_ID));
        Assertions.assertEquals(storage.getByID(ResumeTestData.SECOND_ID).getFullName(), ResumeTestData.FOURTH_NAME);
    }

    @Test
    void saveIncorrect() {
        Assertions.assertThrows(ExistStorageException.class, () -> {
            storage.save(new Resume(ResumeTestData.SECOND_NAME, ResumeTestData.THIRD_ID));
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
        for (int i = 0; i < ResumeTestData.MAX_LENGTH - 3; i++) {
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
        Assertions.assertEquals(testResumesList, Arrays.asList(ResumeTestData.FIRST_RESUME, ResumeTestData.SECOND_RESUME, ResumeTestData.THIRD_RESUME));
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
        storage.deleteByID(ResumeTestData.SECOND_ID);
        Assertions.assertEquals(2, storage.sizeOfArray());
    }

    @Test
    void getIdByValue() {
        int[] testIntArray = storage.getIdByValue(ResumeTestData.SECOND_NAME);
    }
}