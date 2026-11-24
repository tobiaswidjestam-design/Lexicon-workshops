package se.lexicon.workshops.week47.data;

import se.lexicon.workshops.week47.exception.ContactStorageException;
import se.lexicon.workshops.week47.exception.DuplicateContactException;
import se.lexicon.workshops.week47.model.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll() throws ContactStorageException;
    void save(Contact contact) throws ContactStorageException, DuplicateContactException;
    Contact findByName(String name) throws ContactStorageException;
}
