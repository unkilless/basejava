package com.base_java.webapp.storage;

import com.base_java.webapp.storage.strategy.XmlStreamSerializer;

public class XmlPathStorageTest extends CommonTest {

    public XmlPathStorageTest() {
        super(new PathStorage(String.valueOf(STORAGE_DIR), new XmlStreamSerializer()));
    }
}
