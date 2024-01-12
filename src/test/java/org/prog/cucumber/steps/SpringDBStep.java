package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.db.tables.PersonsJpa;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringDBStep {

    @Autowired
    private PersonsJpa personsJpa;

    @Given("a db dry run")
    public void print() {
        personsJpa.findAll().forEach(p -> System.out.println(p));
    }
}
