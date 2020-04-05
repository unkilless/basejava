package com.base_java.webapp.storage;

import com.base_java.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {
    public static final String FIRST_NAME = "Iban";
    public static final int FIRST_ID = 11;
    public static final Resume FIRST_RESUME = new Resume(FIRST_NAME, FIRST_ID);
    public static final String SECOND_NAME = "Gena";
    public static final int SECOND_ID = 22;
    public static final Resume SECOND_RESUME = new Resume(SECOND_NAME, SECOND_ID);
    public static final String THIRD_NAME = "Ibragimn";
    public static final int THIRD_ID = 66;
    public static final Resume THIRD_RESUME = new Resume(THIRD_NAME, THIRD_ID);
    public static final Integer MAX_LENGTH = 10000;
    public static final String FOURTH_NAME = "Georgy";
    public static final int FOURTH_ID = 77;
    public static final Resume FOURTH_RESUME = new Resume(FOURTH_NAME, FOURTH_ID);

    static {
        FIRST_RESUME.setContacts(ContactType.PHONE, new Contact("7-77-77"));
        FIRST_RESUME.setContacts(ContactType.EMAIL, new Contact("123865@mail.ru"));
        FIRST_RESUME.setContacts(ContactType.GITHUB, new Contact("wwww.somegitlink_1.com"));
        FIRST_RESUME.setContacts(ContactType.LINKEDIN, new Contact("www.somelinkedlink_1.com"));
        FIRST_RESUME.setContacts(ContactType.STACKOVERFLOW, new Contact("www.newstakoverflow_1.com"));
        FIRST_RESUME.setContacts(ContactType.SKYPE, new Contact("skype123"));
        FIRST_RESUME.setContacts(ContactType.WEBSITE, new Contact("www.something_1.ru"));
        FIRST_RESUME.setSections(SectionType.PERSONAL, new TextField("kryvoi, kosoi"));
        FIRST_RESUME.setSections(SectionType.ACHIEVEMENT, new TextField("finished MGU"));
        FIRST_RESUME.setSections(SectionType.OBJECTIVE, new ListField(Arrays.asList("some objective 1.1", "some objective 1.2")));
        FIRST_RESUME.setSections(SectionType.QUALIFICATIONS, new ListField(Arrays.asList("some qualification 1.1", "some qualification 1.2")));
        FIRST_RESUME.setSections(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some org 1", "www.link_org_1.ru"), Arrays.asList(new Organization.Position("some org position 1", "some org description 1",LocalDate.of(2001, 1, 1), LocalDate.of(2006, 5, 5)))))));
        FIRST_RESUME.setSections(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some edu 1", "www.link_edu_1.ru"), Arrays.asList(new Organization.Position("some edu position 1", "some edu description 1",LocalDate.of(1997, 9, 1), LocalDate.of(2001, 7, 1)))))));

        SECOND_RESUME.setContacts(ContactType.PHONE, new Contact("7-34-72"));
        SECOND_RESUME.setContacts(ContactType.EMAIL, new Contact("121235@mail.ru"));
        SECOND_RESUME.setContacts(ContactType.GITHUB, new Contact("wwww.somegitlink_2.com"));
        SECOND_RESUME.setContacts(ContactType.LINKEDIN, new Contact("www.somelinkedlink_2.com"));
        SECOND_RESUME.setContacts(ContactType.STACKOVERFLOW, new Contact("www.newstakoverflow_2.com"));
        SECOND_RESUME.setContacts(ContactType.SKYPE, new Contact("skype44"));
        SECOND_RESUME.setContacts(ContactType.WEBSITE, new Contact("www.something_2.ru"));
        SECOND_RESUME.setSections(SectionType.PERSONAL, new TextField("red, black"));
        SECOND_RESUME.setSections(SectionType.ACHIEVEMENT, new TextField("finished RGATu"));
        SECOND_RESUME.setSections(SectionType.OBJECTIVE, new ListField(Arrays.asList("some objective 2.1", "some objective 2.2")));
        SECOND_RESUME.setSections(SectionType.QUALIFICATIONS, new ListField(Arrays.asList("some qualification 2.1", "some qualification 2.2")));
        SECOND_RESUME.setSections(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some org 2", "www.link_org_2.ru"), Arrays.asList(new Organization.Position("some org position 2", "some org description 2",LocalDate.of(2007, 2, 3), LocalDate.of(2019, 11, 5)))))));
        SECOND_RESUME.setSections(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some edu 2", "www.link_edu_2.ru"), Arrays.asList(new Organization.Position("some edu position 2", "some edu description 2",LocalDate.of(2001, 9, 1), LocalDate.of(2006, 7, 1)))))));

        THIRD_RESUME.setContacts(ContactType.PHONE, new Contact("7-11-98"));
        THIRD_RESUME.setContacts(ContactType.EMAIL, new Contact("12843@mail.ru"));
        THIRD_RESUME.setContacts(ContactType.GITHUB, new Contact("wwww.somegitlink_3.com"));
        THIRD_RESUME.setContacts(ContactType.LINKEDIN, new Contact("www.somelinkedlink_3.com"));
        THIRD_RESUME.setContacts(ContactType.STACKOVERFLOW, new Contact("www.newstakoverflow_3.com"));
        THIRD_RESUME.setContacts(ContactType.SKYPE, new Contact("skype654"));
        THIRD_RESUME.setContacts(ContactType.WEBSITE, new Contact("www.something_3.ru"));
        THIRD_RESUME.setSections(SectionType.PERSONAL, new TextField("red, black, lemon"));
        THIRD_RESUME.setSections(SectionType.ACHIEVEMENT, new TextField("finished PTU"));
        THIRD_RESUME.setSections(SectionType.OBJECTIVE, new ListField(Arrays.asList("some objective 3.1")));
        THIRD_RESUME.setSections(SectionType.QUALIFICATIONS, new ListField(Arrays.asList("some qualification 3.1", "some qualification 3.2")));
        THIRD_RESUME.setSections(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some org 3", "www.link_org_3.ru"), Arrays.asList(new Organization.Position("some org position 3", "some org description 3",LocalDate.of(2015, 12, 8), LocalDate.of(2019, 11, 22)))))));
        THIRD_RESUME.setSections(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some edu 3", "www.link_edu_3.ru"), Arrays.asList(new Organization.Position("some edu position 3", "some edu description 3",LocalDate.of(2008, 9, 1), LocalDate.of(2013, 7, 1)))))));

        FOURTH_RESUME.setContacts(ContactType.PHONE, new Contact("2-35-75"));
        FOURTH_RESUME.setContacts(ContactType.EMAIL, new Contact("125405@mail.ru"));
        FOURTH_RESUME.setContacts(ContactType.GITHUB, new Contact("wwww.somegitlink_4.com"));
        FOURTH_RESUME.setContacts(ContactType.LINKEDIN, new Contact("www.somelinkedlink_4.com"));
        FOURTH_RESUME.setContacts(ContactType.STACKOVERFLOW, new Contact("www.newstakoverflow_4.com"));
        FOURTH_RESUME.setContacts(ContactType.SKYPE, new Contact("skype2342"));
        FOURTH_RESUME.setContacts(ContactType.WEBSITE, new Contact("www.something_4.ru"));
        FOURTH_RESUME.setSections(SectionType.PERSONAL, new TextField("red, white"));
        FOURTH_RESUME.setSections(SectionType.ACHIEVEMENT, new TextField("coming here"));
        FOURTH_RESUME.setSections(SectionType.OBJECTIVE, new ListField(Arrays.asList("some objective 4.1", "some objective 4.2")));
        FOURTH_RESUME.setSections(SectionType.QUALIFICATIONS, new ListField(Arrays.asList("some qualification 4.1", "some qualification 4.2")));
        FOURTH_RESUME.setSections(SectionType.EXPERIENCE, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some org 4", "www.link_org_4.ru"), Arrays.asList(new Organization.Position("some org position 4", "some org description 4",LocalDate.of(2010, 7, 8), LocalDate.of(2020, 12, 1)))))));
        FOURTH_RESUME.setSections(SectionType.EDUCATION, new OrganisationSection(Arrays.asList(new Organization(new UrlField("some edu 4", "www.link_edu_4.ru"), Arrays.asList(new Organization.Position("some edu position 4", "some edu description 4",LocalDate.of(2008, 9, 1), LocalDate.of(2012, 7, 1)))))));


    }
}
