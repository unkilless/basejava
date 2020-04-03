package com.base_java.webapp.storage;

import com.base_java.webapp.model.Resume;

public class ResumeTestData {
//    public static final String UUID_1 = "uuid1";
//    public static final String UUID_2 = "uuid2";
//    public static final String UUID_3 = "uuid3";
//    public static final String UUID_4 = "uuid4";
//    public static final Resume RESUME_1 = new Resume(UUID_1, "Frank Rearden");
//    public static final Resume RESUME_2 = new Resume(UUID_2, "Petrov Petr Petrovich");
//    public static final Resume RESUME_3 = new Resume(UUID_3, "Ivanov Ivan Ivanovich");
//    public static final Resume RESUME_4 = new Resume(UUID_4, "Sidorov Ivan Ivanovich");
//
//    static {
//        // Init Resume-1
//        RESUME_1.setSection(SectionType.PERSONAL, new TextSection("Test personal 1"));
//        RESUME_1.setSection(SectionType.OBJECTIVE, new TextSection("Test objective 1"));
//        RESUME_1.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Test achievement 1", "Test achievement 2")));
//        RESUME_1.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("Test qualification 1", "Test qualification 2")));
//        RESUME_1.setSection(SectionType.EXPERIENCE, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageExperience 1", "TestURL"), "Test experience 1", LocalDate.of(2008, 10, 1), LocalDate.of(2013, 10, 1), "University")
//        )));
//        RESUME_1.setSection(SectionType.EDUCATION, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageEducation", "TestURL"), "Test education 1", LocalDate.of(2012, 10, 1), LocalDate.of(2013, 10, 12), "Test description")))
//        );
//        RESUME_1.setContact(ContactType.WEBSITE, "www.testsite.com");
//
//        // Init Resume-2
//        RESUME_2.setSection(SectionType.PERSONAL, new TextSection("Test personal 2"));
//        RESUME_2.setSection(SectionType.OBJECTIVE, new TextSection("Test objective 2"));
//        RESUME_2.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Test achievement 1", "Test achievement 2")));
//        RESUME_2.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("Test qualification 1", "Test qualification 2")));
//        RESUME_2.setSection(SectionType.EXPERIENCE, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageExperience 2", "TestURL"), "Test experience 2", LocalDate.of(2008, 10, 1), LocalDate.of(2013, 10, 1), "University")
//        )));
//        RESUME_2.setSection(SectionType.EDUCATION, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageEducation", "TestURL"), "Test education 2", LocalDate.of(2012, 10, 1), LocalDate.of(2013, 10, 12), "Test description")))
//        );
//        RESUME_2.setContact(ContactType.WEBSITE, "www.testsite.com");
//
//        // Init Resume-3
//        RESUME_3.setSection(SectionType.PERSONAL, new TextSection("Test personal 3"));
//        RESUME_3.setSection(SectionType.OBJECTIVE, new TextSection("Test objective 3"));
//        RESUME_3.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Test achievement 1", "Test achievement 2")));
//        RESUME_3.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("Test qualification 1", "Test qualification 2")));
//        RESUME_3.setSection(SectionType.EXPERIENCE, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageExperience 3", "TestURL"), "Test experience 3", LocalDate.of(2008, 10, 1), LocalDate.of(2013, 10, 1), "University")
//        )));
//        RESUME_3.setSection(SectionType.EDUCATION, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageEducation", "TestURL"), "Test education 3", LocalDate.of(2012, 10, 1), LocalDate.of(2013, 10, 12), "Test description")))
//        );
//        RESUME_3.setContact(ContactType.WEBSITE, "www.testsite.com");
//
//        // Init Resume-4
//        RESUME_4.setSection(SectionType.PERSONAL, new TextSection("Test personal 4"));
//        RESUME_4.setSection(SectionType.OBJECTIVE, new TextSection("Test objective 4"));
//        RESUME_4.setSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Test achievement 1", "Test achievement 2")));
//        RESUME_4.setSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("Test qualification 1", "Test qualification 2")));
//        RESUME_4.setSection(SectionType.EXPERIENCE, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageExperience 4", "TestURL"), "Test experience 4", LocalDate.of(2008, 10, 1), LocalDate.of(2013, 10, 1), "University")
//        )));
//        RESUME_4.setSection(SectionType.EDUCATION, new InstitutionSection(Arrays.asList(
//                new Institution(new HyperLink("TestPageEducation", "TestURL"), "Test education 4", LocalDate.of(2012, 10, 1), LocalDate.of(2013, 10, 12), "Test description")))
//        );
//        RESUME_4.setContact(ContactType.WEBSITE, "www.testsite.com");
//    }

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
            synchronized (ResumeTestData.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ResumeTestData();
                }
            }
            System.out.println("отработал getInstance");
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        ResumeTestData instance = ResumeTestData.getInstance();


    }
}
