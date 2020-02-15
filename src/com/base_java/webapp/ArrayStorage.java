package com.base_java.webapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArrayStorage {
    static int MAX_LENGHT = 10000;
    private Resume[] resumes = new Resume[MAX_LENGHT];

    private static int size = 0;

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


    public int sizeOfArray() {
        return size;
    }

    public void input(String inputStr, int passID) {
        if (getByID(passID) == "NO_DATA") {
            resumes[size] = new Resume(inputStr, passID);
            size++;
        } else
            System.out.println("Same ID. Can't allowed enter this info");
    }

    public void printAll() {
        for (int i = 0; i < size; i++)
            System.out.println("ID: " + resumes[i].getId() + " Data: " + resumes[i].getFullName() + ";");
    }

    public String getByID(int ID) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (resumes[i].getId() == ID)
                    return resumes[i].getFullName();
            }
        }
        return "NO_DATA";
    }

    public void deleteByID(int ID) {
        boolean f_finded = false;
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                if (resumes[i].getId() == ID) {
                    if (i != size - 1) {
                        resumes[i].setFullName(resumes[size - 1].getFullName());
                        resumes[i].setId(resumes[size - 1].getId());
                        size--;
                        f_finded = true;
                    } else {
                        resumes[i].setFullName(null);
                        resumes[i].setId(0);
                        size--;
                        f_finded = true;
                    }
                }
            }
        }
        if (!f_finded) System.out.println("Not found any person with this id");
    }

    public void deleteAll() {
        for (int i = 0; i < size; i++) {
            resumes[i].setId(0);
            resumes[i].setFullName(null);
        }
        size = 0;
    }

    public int getIdByValue(String findingStr){
        for (int i = 0; i < size; i++){
            if (resumes[i].getFullName() == findingStr)
                return resumes[i].getId();
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<Integer, String> MyBase = new HashMap<Integer, String>();
        ArrayStorage MyArray = new ArrayStorage();
        int IDs = 0;
        MyArray.input("Ivan", 113);
        MyArray.input("Peotr", 256);
        MyArray.input("Max", 37);
        //MyArray.printAll();
        System.out.println(MyArray.getByID(37));
        System.out.println(MyArray.sizeOfArray());
        //MyArray.deleteByID(37);
        MyArray.deleteByID(13);
        MyArray.input("German", 37);
        //MyArray.deleteAll();
        MyArray.printAll();
        //MyArray.deleteByID(256);
        //System.out.println(MyArray.getByID(222));
        //System.out.println(MyArray.getIdByValue("Ivan"));
        //System.out.println(MyArray.getIdByValue("Eugen"));

    }
}
