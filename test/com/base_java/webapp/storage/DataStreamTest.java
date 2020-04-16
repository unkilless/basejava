package com.base_java.webapp.storage;

import com.base_java.webapp.storage.strategy.DataStreamSerializer;

public class DataStreamTest extends CommonTest {
    public DataStreamTest() {
        super(new PathStorage(String.valueOf(STORAGE_DIR), new DataStreamSerializer()));
    }
}
