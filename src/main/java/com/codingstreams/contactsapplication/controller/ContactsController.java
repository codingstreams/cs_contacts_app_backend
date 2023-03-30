package com.codingstreams.contactsapplication.controller;

import com.codingstreams.contactsapplication.dto.ContactRequest;
import com.codingstreams.contactsapplication.exception.ContactNotFoundException;
import com.codingstreams.contactsapplication.exception.LabelNotFoundException;
import com.codingstreams.contactsapplication.model.Contact;
import com.codingstreams.contactsapplication.service.contacts.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/")
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @GetMapping("/")
    public List<Contact> getContacts() {
        return contactsService.getContacts();
    }

    @GetMapping("/byLabel/{labelId}")
    public List<Contact> getContactsByLabel(@PathVariable Integer labelId) throws LabelNotFoundException {
        return contactsService.getContactsByLabel(labelId);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody ContactRequest contactRequest) throws LabelNotFoundException {
        return contactsService.saveContact(contactRequest);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody ContactRequest contactRequest) throws LabelNotFoundException, ContactNotFoundException {
        return contactsService.updateContact(id, contactRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Integer id) throws ContactNotFoundException {
        contactsService.deleteContact(id);
    }
}
