package com.base_java.webapp;

import java.util.Scanner;

public class MainArray {

    public static void main(String[] args) {
        ArrayStorage MyArray = new ArrayStorage();
        Resume[] resumes = new Resume[10000];
        Scanner input = new Scanner(System.in);
        String bufferedFullName = "";
        int bufferedID = 0;
        int command;

        while (true) {
            System.out.println("//Enter menu command:");
            System.out.println("1: save; \n" +
                    "2: print all; \n" +
                    "3: delete by ID; \n" +
                    "4: delete all resumes; \n" +
                    "5: get by ID; \n" +
                    "6: count database; \n" +
                    "0: exit");
            command = input.nextInt();
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

                    Resume newResume = new Resume(bufferedFullName, bufferedID);
                    MyArray.save(newResume);

                    System.out.println("Resume is added!" + MyArray.sizeOfArray());
                    break;
//--------------------------------------------------------------------
                case (2):
                    resumes = MyArray.getAll();
                    System.out.println("List of resumes:");
                    for (int j = 0; j < MyArray.sizeOfArray(); j++)
                        System.out.println("ID: " + resumes[j].getId() + " Name: " + resumes[j].getFullName() + ";");
                    break;
//--------------------------------------------------------------------
                case (3):
                    System.out.println("Pls enter resume ID:");
                    bufferedID = input.nextInt();
                    MyArray.deleteByID(bufferedID);
                    break;
//--------------------------------------------------------------------
                case (4):
                    MyArray.deleteAll();
                    System.out.println("Database is empty");
                    break;
//--------------------------------------------------------------------
                case (5):
                    System.out.println("Pls enter resume ID:");
                    bufferedID = input.nextInt();
                    if (MyArray.getByID(bufferedID) != null)
                        System.out.println("Your record: \n ID: " + MyArray.getByID(bufferedID).getId() + " Name: " + MyArray.getByID(bufferedID).getFullName());
                    else
                        System.out.println("Record not exist!");
                    break;
//--------------------------------------------------------------------
                case (6):
                    System.out.println("Record's count is " + MyArray.sizeOfArray());
                    break;
//--------------------------------------------------------------------
                default:
                    System.out.println("//Incorrect command. Enter menu command:");

            }
        }
    }


}
