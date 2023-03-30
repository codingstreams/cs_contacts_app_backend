package com.codingstreams.contactsapplication.repository;

import com.codingstreams.contactsapplication.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<Contact, Integer> {
}
