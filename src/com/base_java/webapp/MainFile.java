package com.base_java.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainFile {

    public static List<File> getListFiles(File checkingFile) {
        List<File> listFiles = new ArrayList<>();
        if (checkingFile.isDirectory()) {
            listFiles = Arrays.asList(checkingFile.listFiles());
            Iterator<File> it = listFiles.iterator();
            while (it.hasNext()) {
                File bufFile = it.next();
                if (bufFile.isDirectory()) {
                    List<File> bufferList = new ArrayList<>();
                    bufferList = getListFiles(bufFile);
                    listFiles = Stream.concat(listFiles.stream(), bufferList.stream())
                            .collect(Collectors.toList());
                }
            }
            return listFiles;
        }
        return null;

//        File[] _files = Objects.requireNonNull(checkingFile.listFiles());
//        for (File file : _files) {
//            if (file.isDirectory()) {
//                getListFiles(file, files);
//            } else {
//                files.add(file);
//            }
//        }
//        return files;
    }

    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("L:\\Repositories\\basejava");
        File nextFile = null;
        List<File> listFiles = new ArrayList<>();

        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        listFiles = getListFiles(dir);
        Iterator<File> iterator = listFiles.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        try (
                FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}