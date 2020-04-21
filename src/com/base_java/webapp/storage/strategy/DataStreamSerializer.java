package com.base_java.webapp.storage.strategy;

import com.base_java.webapp.exception.StorageException;
import com.base_java.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataStreamSerializer implements AbstractStrategy {

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
                    dos.writeInt(((ListField) section).getListField().size());
                    ((ListField) section).getListField().forEach(s -> writeList(dos, s));
                    break;
                case EDUCATION:
                case EXPERIENCE:
                    dos.writeUTF(String.valueOf(sectionType));
                    dos.writeInt(((OrganisationSection) section).getListField().size());
                    ((OrganisationSection) section).getListField().forEach(organization -> writeOrganizationField(dos, organization));
                    break;
                default:
                    return;
            }
        } catch (IOException e) {
            throw new StorageException("Cant write section info", 0, e);
        }
    }

    private void writeOrganizationField(DataOutputStream dos, Organization organization) {
        try {
            dos.writeUTF(organization.getOrganisationInfo().getName());
            dos.writeUTF(organization.getOrganisationInfo().getUrl());
            dos.writeInt(organization.getPositions().size());
            organization.getPositions().forEach(position -> writePosition(dos, position));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writePosition(DataOutputStream dos, Organization.Position position) {
        try {
            dos.writeUTF(position.getTitle());
            dos.writeUTF(position.getDescription());
            dos.writeUTF(String.valueOf(position.getDateStart()));
            dos.writeUTF(String.valueOf(position.getDateEnd()));
        } catch (IOException e) {
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

    @FunctionalInterface
    private interface DataStreamWriter<T> {
        void write(T t) throws IOException;
    }

    private <T> void writeContent(DataOutputStream dataOutputStream, Collection<T> collection, DataStreamWriter<T> writer) throws IOException {
        dataOutputStream.writeInt(collection.size());
        for (T element : collection) {
            writer.write(element);
        }
    }

    @Override
    public void writeResume(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeInt(resume.getId());
            dos.writeUTF(resume.getFullName());
            writeContent(dos, resume.getContacts().entrySet(), contact -> {
                dos.writeUTF(contact.getKey().name());
                dos.writeUTF(String.valueOf(contact.getValue().getContact()));
            });
            writeContent(dos, resume.getSections().entrySet(), section -> {
                writeSectionField(dos, section.getKey(), section.getValue());
            });
        }
    }

    @Override
    public Resume readResume(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            int id = dis.readInt();
            String fullName = dis.readUTF();
            Resume resume = new Resume(fullName, id);

            readContent(dis, () -> {
                resume.setContact(ContactType.valueOf(dis.readUTF()), new Contact(dis.readUTF()));
            });
            readContent(dis, () -> {
                readSection(dis, resume);
            });
            return resume;
        }
    }

    @FunctionalInterface
    private interface SectionHandler<T> {
        void handle() throws IOException;
    }

    private <T> void readContent(DataInputStream dataInputStream, SectionHandler<T> reader) throws IOException {
        int sizeBlock = dataInputStream.readInt();
        for (int i = 0; i < sizeBlock; i++) {
            reader.handle();
        }
    }

    private void readSection(DataInputStream dis, Resume resume) throws IOException {
        SectionType sectionType = SectionType.valueOf(dis.readUTF());
        switch (sectionType) {
            case PERSONAL:
            case ACHIEVEMENT:
                resume.setSection(sectionType, new TextField(dis.readUTF()));
                break;
            case OBJECTIVE:
            case QUALIFICATIONS:
                resume.setSection(sectionType, new ListField(readElementList(dis, () -> dis.readUTF())));
                break;
            case EDUCATION:
            case EXPERIENCE:
/*                List<Organization> bufferedOrganizationList = new ArrayList<>();
                int sizeBlockEduAndExp = dis.readInt();
                for (int i = 0; i < sizeBlockEduAndExp; i++) {
                    UrlField organizationInfo = new UrlField(dis.readUTF(), dis.readUTF());
                    int sizeBlockPosition = dis.readInt();
                    List<Organization.Position> bufferedPositionList = new ArrayList<>();
                    for (int j = 0; j < sizeBlockPosition; j++) {
                        bufferedPositionList.add(new Organization.Position(
                                dis.readUTF(),
                                dis.readUTF(),
                                LocalDate.parse(dis.readUTF()),
                                LocalDate.parse(dis.readUTF())));
                    }
                    bufferedOrganizationList.add(new Organization(organizationInfo, bufferedPositionList));
                }
                resume.setSection(sectionType, new OrganisationSection(bufferedOrganizationList));*/
                resume.setSection(sectionType, new OrganisationSection(readElementList(dis, () ->
                    new Organization(
                            new UrlField(dis.readUTF(), dis.readUTF()),
                            readElementList(dis, () -> new Organization.Position(dis.readUTF(), dis.readUTF(), readLocalDate(dis), readLocalDate(dis)))
                    )
                )));
                break;
            default:
                throw new IllegalStateException(String.format("Некорректная секция: %s", sectionType));
        }
    }

    private LocalDate readLocalDate(DataInputStream dataInputStream) throws IOException {
        return LocalDate.parse(dataInputStream.readUTF());
    }

    @FunctionalInterface
    private interface DataStreamReader<T> {
        T read() throws IOException;
    }

    private <T> List<T> readElementList(DataInputStream dataInputStream, DataStreamReader<T> reader) throws IOException {
        int size = dataInputStream.readInt();
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }
}
