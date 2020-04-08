package com.base_java.webapp.storage;

import static org.junit.jupiter.api.Assertions.*;

class ObjectStreamPathStorageTest extends CommonTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(String.valueOf(STORAGE_DIR)));
    }
}