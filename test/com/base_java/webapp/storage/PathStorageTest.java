package com.base_java.webapp.storage;


import com.base_java.webapp.storage.strategy.ObjectStreamStrategy;

class PathStorageTest extends CommonTest {

    public PathStorageTest() {
        super(new PathStorage(String.valueOf(STORAGE_DIR), new ObjectStreamStrategy()));
    }
}