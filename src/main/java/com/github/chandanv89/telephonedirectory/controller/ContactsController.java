package com.github.chandanv89.telephonedirectory.controller;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.repository.ContactsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Contacts controller.
 */
@RestController
@RequestMapping("/rest/contacts/")
public class ContactsController {
    private ContactsRepository repository;

    /**
     * Instantiates a new Contacts controller.
     *
     * @param repository the repository
     */
    public ContactsController(ContactsRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/")
    public List<Contact> getAll() {
        return repository.findAll();
    }

    /**
     * Insert.
     *
     * @param contact the contact
     */
    @PostMapping("/")
    public void insert(@RequestBody Contact contact) {
        repository.insert(contact);
    }

    /**
     * Update.
     *
     * @param contact the contact
     */
    @PutMapping
    public void update(@RequestBody Contact contact) {
        repository.save(contact);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }
}
