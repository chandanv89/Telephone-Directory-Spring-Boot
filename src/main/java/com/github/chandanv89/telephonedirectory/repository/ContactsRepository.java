package com.github.chandanv89.telephonedirectory.repository;

import com.github.chandanv89.telephonedirectory.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Contacts repository.
 */
@Repository
public interface ContactsRepository extends MongoRepository<Contact, String> {
}
