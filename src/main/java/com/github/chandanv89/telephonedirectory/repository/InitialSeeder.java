package com.github.chandanv89.telephonedirectory.repository;

import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.model.ContactCategory;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.model.Email;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

/**
 * The type Initial seeder.
 */
@Component
public class InitialSeeder implements CommandLineRunner {
    private ContactsRepository repository;

    /**
     * Instantiates a new Initial seeder.
     *
     * @param repository the repository
     */
    public InitialSeeder(ContactsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Contact sam = new Contact();
        sam.setLastName("Winchester");
        sam.setFirstName("Sam");
        sam.setContactNumbers(Arrays.asList(
                new ContactNumber("+1234567890", ContactCategory.PERSONAL, true),
                new ContactNumber("+1097555732", ContactCategory.WORK, false)));
        sam.setEmails(Collections.singletonList(
                new Email("sam.winchester@example.com", ContactCategory.PERSONAL, true)
        ));

        Contact dean = new Contact();
        dean.setLastName("Winchester");
        dean.setFirstName("Dean");
        dean.setContactNumbers(Arrays.asList(
                new ContactNumber("+44123988294", ContactCategory.PERSONAL, true),
                new ContactNumber("+44986383334", ContactCategory.WORK, false)));
        dean.setEmails(Arrays.asList(
                new Email("dean.winchester@example.com", ContactCategory.PERSONAL, true),
                new Email("dean.winchester@xyz.com", ContactCategory.WORK, true)
        ));

        // delete previous data
        this.repository.deleteAll();

        // save them again!
        this.repository.saveAll(Arrays.asList(sam, dean));
    }
}
