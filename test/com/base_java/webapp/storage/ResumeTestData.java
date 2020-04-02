package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

public class ResumeTestData {
    private static ResumeTestData INSTANCE;

    private String FIRST_NAME;
    private int FIRST_ID;
    private Resume FIRST_RESUME;
    public String SECOND_NAME;
    private int SECOND_ID;
    private Resume SECOND_RESUME;
    private String THIRD_NAME;
    private int THIRD_ID;
    private Resume THIRD_RESUME;
    private Integer MAX_LENGTH;
    private String FOURTH_NAME;
    private int FOURTH_ID;

    private ResumeTestData(){
        FIRST_NAME = "Iban";
        FIRST_ID = 11;
        FIRST_RESUME = new Resume(FIRST_NAME, FIRST_ID);
        SECOND_NAME = "Gena";
        SECOND_ID = 22;
        SECOND_RESUME = new Resume(SECOND_NAME, SECOND_ID);
        THIRD_NAME = "Ibragimn";
        THIRD_ID = 66;
        THIRD_RESUME = new Resume(THIRD_NAME, THIRD_ID);
        MAX_LENGTH = 10000;
        FOURTH_NAME = "Georgy";
        FOURTH_ID = 77;
    }

    public static ResumeTestData getInstance() {
        if (INSTANCE == null){
            INSTANCE = new ResumeTestData();
            System.out.println("отработал getInstance");
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        ResumeTestData.getInstance();
        System.out.println(ResumeTestData.INSTANCE.FIRST_NAME);

    }
}
