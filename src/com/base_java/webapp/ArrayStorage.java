package com.base_java.webapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArrayStorage {
    static int MAX_LENGHT = 10000;
    private Resume[] resumes = new Resume[MAX_LENGHT];

    private int size = 0;

    public void ShowMap(Map<Integer, String> WathedMap) {
        /*int i = 1;
        while (i <= WathedMap.size()){
            System.out.println(WathedMap.get(i));
            i++;
        }*/
        int UID;
        for (Map.Entry<Integer, String> current : WathedMap.entrySet()) {
            System.out.println("Checked");
        }
    }

    public String GetByID(Map WatchedMap, int ID) throws IOException {
        if (ID > 0 || ID < WatchedMap.size())
            return WatchedMap.get(ID).toString();
        else {
            return "Illegal ID";
        }
    }

    public void DeleteByID(Map WatchedMap, int ID) {
        if (ID > 0 || ID < WatchedMap.size()) {
            WatchedMap.remove(ID);
            System.out.println("Element with ID: " + ID + " was deleted");
        } else {
            System.out.println("Incorrect ID");
        }
    }

    public void PrintToFile(Map WathedMap, String PATH) throws IOException {
        int i = 1;
        try {
            FileWriter OutputFile = new FileWriter(PATH, true);
            while (i <= WathedMap.size()) {
                OutputFile.write(WathedMap.get(i).toString());
            }
            OutputFile.close();
        } catch (IOException ex) {
            System.out.println("Bad path");
        }
    }

    public void InsertToEnd(Map WatchedMap, String NewData) {
        WatchedMap.put(WatchedMap.size() + 1, NewData);
    }

    public void ClearMap(Map WatchedMap) {
        WatchedMap.clear();
        System.out.println("Your base is empty now");
    }

    public void sortingMap(Map<Integer, String> WatchedMap) {
        WatchedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    // save
    // get
    // update
    // delete


    public void print() {
        if (size != 0)
            for (int i = 0; i <= size; i++)
                System.out.println(resumes[i].toString());
    }

    public int sizeOfArray() {
        return size;
    }

    public void input(String inputStr) {
        resumes[size] = new Resume(inputStr);
        size++;
    }


    public static void main(String[] args) {
        Map<Integer, String> MyBase = new HashMap<Integer, String>();
        ArrayStorage MyArray = new ArrayStorage();
        MyArray.input("Jopa");
        System.out.println(MyArray.resumes[0].getFullName());
    }
}
