package com.base_java.webapp.storage;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.strategy.AbstractStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;

    private AbstractStrategy strategy;

    public PathStorage(String dir, AbstractStrategy strategy) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory not must be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }

        this.strategy = strategy;
    }

    @Override
    protected List<Resume> convertToListStorage() {
        Stream<Path> listPaths = null;
        try {
            listPaths = Files.list(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Resume> resumesList = new ArrayList<>();
        if (listPaths == null){
            throw new StorageException("Empty directory", 0);
        }
        else{
            listPaths.forEach(path -> {resumesList.add(doGet(path));});
        }
        listPaths.close();
        return resumesList;
    }

    @Override
    protected Path getSearchKey(Integer id) {
        return Paths.get(directory.toString(), String.valueOf(id));
    }

    @Override
    protected void doUpdate(Path path, Resume resumeForUpd) {
        try {
            strategy.writeResume(resumeForUpd, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Can't write file", resumeForUpd.getId(), e);
        }
    }

    @Override
    protected void doSave(Path path, Resume savingResume) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Cant create save file", savingResume.getId(), e);
        }
        doUpdate(path, savingResume);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return strategy.readResume(new BufferedInputStream(new FileInputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Cant read file", 0, e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Cant delete file", 0, e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    public int sizeOfArray() {
        try {
            return (int) Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("Error in method size of", 0, e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Cant delete all resumes", 0);
        }
    }

    @Override
    public int[] getIdByValue(String findingStr) {
        return new int[0];
    }
}
