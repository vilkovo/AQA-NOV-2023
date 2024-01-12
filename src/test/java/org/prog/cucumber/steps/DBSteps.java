package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.db.tables.Persons;
import org.prog.db.tables.PersonsJpa;
import org.prog.util.DataHolder;
import org.prog.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class DBSteps {

    @Autowired
    private DataHolder dataHolder;

    @Autowired
    private PersonsJpa personsJpa;

    @Given("I store {string} users to DB")
    public void storeusersToDB(String alias) {
        List<PersonDto> persons = (List<PersonDto>) dataHolder.get(alias);
        if (persons == null || persons.isEmpty()) {
            Assert.fail("No persons fetched! Please refer RestSteps for 'requestUsersFromService' method");
        }

        for (PersonDto dto : persons) {
            Persons p1 = personsJpa.save(Persons.fromDto(dto));
            System.out.println(p1.getPersonId());
        }
    }

    @Given("I retrieve a random user from DB as {string}")
    public void retrieveRandomUser(String alias) {
        Persons persons = personsJpa.getRandomPerson().get();
        dataHolder.put(alias, PersonDto.fromDb(persons));
    }
}
