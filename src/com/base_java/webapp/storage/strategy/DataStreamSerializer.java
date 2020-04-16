package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.*;

import java.io.*;

public class DataStreamSerializer implements AbstractStrategy {

    private void writeContactField(DataOutputStream dos, ContactType contactType, Contact contact) {
        try {
            switch (contactType) {
                case PHONE:
                case SKYPE:
                case EMAIL:
                case LINKEDIN:
                case GITHUB:
                case STACKOVERFLOW:
                case WEBSITE:
                    dos.writeUTF(String.valueOf(contactType));
                    dos.writeUTF(String.valueOf(contact));
                    break;
                default:
                    return;
            }
        } catch (IOException e) {
            throw new StorageException("Cant write contact info", 0);
        }
    }

    private void writeSectionField(DataOutputStream dos, SectionType sectionType, AbstractSection section) {
        try {
            switch (sectionType) {
                case PERSONAL:
                case ACHIEVEMENT:
                    dos.writeUTF(String.valueOf(sectionType));
                    dos.writeUTF(String.valueOf(section));
                    break;
                case OBJECTIVE:
                case QUALIFICATIONS:
                    dos.writeUTF(String.valueOf(sectionType));
                    ListField bufferListField = (ListField) section;
                    bufferListField.getListField().forEach(s -> writeList(dos, s));
                    break;
                case EDUCATION:
                case EXPERIENCE:
                    dos.writeUTF(String.valueOf(sectionType));
                    OrganisationSection bufferOrganizationSection = (OrganisationSection) section;
                    bufferOrganizationSection.getListField().forEach(organization -> writeOrganizationField(dos, organization));
                    break;
                default:
                    return;
            }
        } catch(IOException e) {
            throw new StorageException("Cant write section info", 0, e);
        }
    }

    private void writeOrganizationField(DataOutputStream dos, Organization organization) {
        try {
            dos.writeUTF(organization.getOrganisationInfo().getName());
            dos.writeUTF(organization.getOrganisationInfo().getUrl());
            organization.getPositions().forEach(position -> writePosition(dos, position));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writePosition(DataOutputStream dos, Organization.Position position) {
        try{
            dos.writeUTF(String.valueOf(position.getDateStart()));
            dos.writeUTF(String.valueOf(position.getDateEnd()));
            dos.writeUTF(position.getTitle());
            dos.writeUTF(position.getDescription());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void writeList(DataOutputStream dos, String s) {
        try {
            dos.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeResume(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeInt(resume.getId());
            dos.writeUTF(resume.getFullName());
            dos.writeInt(resume.getContacts().size());
            resume.getContacts().forEach((contactType, contact) -> writeContactField(dos, contactType, contact));
            resume.getSections().forEach(((sectionType, section) -> writeSectionField(dos, sectionType, section)));
        }
        // TODO implements sections

    }

    @Override
    public Resume readResume(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            int id = dis.readInt();
            String fullName = dis.readUTF();
            Resume resume = new Resume(fullName, id);
            int sizeBlock = dis.readInt();
            for (int i = 0; i < sizeBlock; i++) {
                ContactType bufferedContactType = ContactType.valueOf(dis.readUTF());
                Contact bufferedContact = new Contact(dis.readUTF());
                resume.setContact(bufferedContactType, bufferedContact);
            }
            return resume;
        }
    }
}
