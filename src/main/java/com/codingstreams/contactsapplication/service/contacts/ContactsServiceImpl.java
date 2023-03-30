package com.codingstreams.contactsapplication.service.contacts;

import com.codingstreams.contactsapplication.dto.ContactRequest;
import com.codingstreams.contactsapplication.exception.ContactNotFoundException;
import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Contact;
import com.codingstreams.contactsapplication.model.Label;
import com.codingstreams.contactsapplication.repository.ContactsRepository;
import com.codingstreams.contactsapplication.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contactsRepository.findAll().forEach(contacts::add);
        return contacts;
    }

    @Override
    public Contact saveContact(ContactRequest contactRequest) throws LabelNotFoundException {
        // Create contact
        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setEmail(contactRequest.getEmail());
        contact.setPhone(contactRequest.getPhone());

        // Get label
        Integer labelId = contactRequest.getLabelId();
        Label label = labelRepository.findById(labelId)
                .orElseThrow(LabelNotFoundException::new);

        // Assign label to contact
        contact.setLabel(label);

        // Save contact
        Contact savedContact = contactsRepository.save(contact);

        // Return saved contact
        return savedContact;
    }

    @Override
    public Contact updateContact(Integer id, ContactRequest contactRequest) throws ContactNotFoundException, LabelNotFoundException {
        // Check if contact exists or not
        boolean exists = contactsRepository.existsById(id);

        // If not exists then throw error
        if (!exists) throw new ContactNotFoundException();

        // Else update contact
        Contact savedContact = saveContact(contactRequest);

        // Return updated contact
        return savedContact;
    }

    @Override
    public void deleteContact(Integer id) throws ContactNotFoundException {
        // Check if contact exists or not
        boolean exists = contactsRepository.existsById(id);

        // If not exists then throw error
        if (!exists) throw new ContactNotFoundException();

        // Else delete contact
        contactsRepository.deleteById(id);
    }

    @Override
    public List<Contact> getContactsByLabel(Integer labelId) throws LabelNotFoundException {
        Label label = labelRepository.findById(labelId).orElseThrow(LabelNotFoundException::new);
        return label.getContacts();
    }
}
