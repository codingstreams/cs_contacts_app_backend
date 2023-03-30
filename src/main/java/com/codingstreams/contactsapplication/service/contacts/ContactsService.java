package com.codingstreams.contactsapplication.service.contacts;

import com.codingstreams.contactsapplication.dto.ContactRequest;
import com.codingstreams.contactsapplication.exception.ContactNotFoundException;
import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Contact;

import java.util.List;

public interface ContactsService {
    List<Contact> getContacts();

    Contact saveContact(ContactRequest contactRequest) throws LabelNotFoundException;

    Contact updateContact(Integer id, ContactRequest contactRequest) throws ContactNotFoundException, LabelNotFoundException;

    void deleteContact(Integer id) throws ContactNotFoundException;

    List<Contact> getContactsByLabel(Integer labelId) throws LabelNotFoundException;
}
