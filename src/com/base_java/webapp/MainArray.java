package com.base_java.webapp;

import com.base_java.webapp.exception.NotExistStorageException;
import com.base_java.webapp.model.Resume;
import com.base_java.webapp.storage.ArrayStorage;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainArray {

    private static ArrayStorage resumesArray = new ArrayStorage();

    public static void main(String[] args) {
        Resume[] resumes = new Resume[10000];
        Scanner input = new Scanner(System.in);
        Resume newResume;
        String bufferedFullName = "";
        int bufferedID = 0;
        int command = 8;

        System.out.println("//Enter menu command:");

        while (true) {

            System.out.println("1: save; \n" +
                    "2: print all; \n" +
                    "3: delete by ID; \n" +
                    "4: delete all resumes; \n" +
                    "5: get by ID; \n" +
                    "6: count database; \n" +
                    "7: update by ID \n" +
                    "0: exit");
            try {
                command = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input symbols." + e.getLocalizedMessage() + " Try one more");
                input.nextLine();
            }
//--------------------------------------------------------------------
            switch (command) {
                case (0):
                    return;
//--------------------------------------------------------------------
                case (1):
                    boolean correctInput = false;
                    while (correctInput != true) {
                        System.out.println("Pls enter new resume fullname:");
                        bufferedFullName = input.next().toString();
                        if (!bufferedFullName.trim().isEmpty()) {
                            bufferedFullName.trim().toLowerCase();
                            if (bufferedFullName.matches("[a-z]+"))
                                correctInput = true;
                        }
                    }
                    correctInput = false;
                    while (correctInput != true) {
                        System.out.println("Pls enter new resume ID:");
                        bufferedID = input.nextInt();
                        if (bufferedID >= 0)
                            correctInput = true;
                    }

                    newResume = new Resume(bufferedFullName, bufferedID);
                    resumesArray.save(newResume);
                    break;
//--------------------------------------------------------------------
                case (2):

                    List<Resume> outputList = resumesArray.getAllSorted();
                    System.out.println("List of resumes:");
                    for (Resume resume : outputList) {
                            System.out.println("ID: " + resume.getId() + " Name: " + resume.getFullName() + ";");
                    }
                    break;
//--------------------------------------------------------------------
                case (3):
                    System.out.println("Pls enter resume ID:");
                    try {
                        bufferedID = input.nextInt();
                        resumesArray.deleteByID(bufferedID);
                    } catch (NotExistStorageException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
//--------------------------------------------------------------------
                case (4):
                    resumesArray.deleteAll();
                    System.out.println("Database is empty");
                    break;
//--------------------------------------------------------------------
                case (5):
                    System.out.println("Pls enter resume ID:");
                    bufferedID = input.nextInt();
                    try {
                        Resume findedResume = new Resume("", 0);
                        findedResume = resumesArray.getByID(bufferedID);
                        System.out.println("Your record: \n ID: " + findedResume.getId() + " Name: " + findedResume.getFullName());
                    } catch (NullPointerException e) {
                        System.out.println("Resume with ID: " + bufferedID + " are not exist");
                    }
                    break;
//--------------------------------------------------------------------
                case (6):
                    System.out.println("Record's count is " + resumesArray.sizeOfArray());
                    break;
//--------------------------------------------------------------------
                case (7):
                    System.out.println("Pls enter resume ID:");
                    bufferedID = input.nextInt();
                    boolean correctInputUpd = false;
                    while (correctInputUpd != true) {
                        System.out.println("Pls input new fullname:");
                        bufferedFullName = input.next().toString();
                        if (!bufferedFullName.trim().isEmpty()) {
                            bufferedFullName.trim().toLowerCase();
                            if (bufferedFullName.matches("[a-z]+"))
                                correctInputUpd = true;
                        }
                    }
                    newResume = new Resume(bufferedFullName, bufferedID);
                    resumesArray.update(newResume);
                    break;
//--------------------------------------------------------------------
                default:
                    System.out.println("//Incorrect command. Enter menu command:");

            }
        }
    }


}
