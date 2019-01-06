package com.github.chandanv89.telephonedirectory.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandanv89.telephonedirectory.model.Contact;
import com.github.chandanv89.telephonedirectory.model.ContactCategory;
import com.github.chandanv89.telephonedirectory.model.ContactNumber;
import com.github.chandanv89.telephonedirectory.model.Email;
import com.github.chandanv89.telephonedirectory.utility.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The type Initial seeder.
 */
@Component
public class InitialSeeder implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(InitialSeeder.class);

    @Autowired
    private ContactsRepository repository;

    @Override
    public void run(String... args) {
        LOGGER.info("Initialising the DB with dummy app data...");
        List<Contact> contacts = initializeContacts();

        try {
            JSONParser parser = new JSONParser();
            JSONArray obj = (JSONArray) parser.parse(new FileReader(new ClassPathResource("smple.json").getFile()));

            LOGGER.info("{}", obj.toJSONString());
            List<Contact> contactList = new ObjectMapper().readValue(obj.toJSONString(), new TypeReference<ArrayList<Contact>>() {
            });
            LOGGER.info("Contacts read from the file: {}", Utilities.toString(contactList));

        } catch (ParseException e) {
            LOGGER.error(e);
            contacts = initializeContacts();
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFound: ", e);
            contacts = initializeContacts();
        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
            contacts = initializeContacts();
        }

        // delete previous data
        this.repository.deleteAll();

        // save them again!
        this.repository.saveAll(contacts);
    }

    private List<Contact> initializeContacts() {
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

        return Arrays.asList(sam, dean);
    }
}
