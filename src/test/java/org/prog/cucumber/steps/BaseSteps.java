package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.elements.GoogleElements;

public class BaseSteps {

    public static final String SOME_NAME = "GOOGLE_LOGO";

    //    "GOOGLE_LOGO"
    @Given("I print {string}")
    public void printA(String s) {
        if (GoogleElements.GOOGLE_LOGO.name().equals(s.toUpperCase())) {
            System.out.println("Google logo element!");
            GoogleElements ge = GoogleElements.valueOf(s.toUpperCase());
            System.out.println(ge.equals(GoogleElements.GOOGLE_SEARCH_BTN));
            System.out.println(ge.equals(GoogleElements.GOOGLE_LOGO));
        } else {
            System.out.println("Not a Google logo element!");
        }


        System.out.println(s);
    }

    @Given("I check google element {}")
    public void checkEnumElement(GoogleElements s) {
        System.out.println(s.getLocator());
        System.out.println(s.name());
    }

    @Given("I print {string} and {string}")
    public void printA(String s1, String s2) {
        System.out.println(s1 + s2);
    }
}
