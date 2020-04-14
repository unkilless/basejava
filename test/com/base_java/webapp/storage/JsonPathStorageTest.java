package com.base_java.webapp.storage;

import com.base_java.webapp.storage.strategy.JsonStreamSerializer;

public class JsonPathStorageTest extends CommonTest {
    public JsonPathStorageTest() {
        super(new PathStorage(String.valueOf(STORAGE_DIR), new JsonStreamSerializer()));
    }
}
