package org.HomeWork.HomeWork7;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import HomeWork.HomeWork7.Person;
import HomeWork.HomeWork7.SearchResults;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestTests {

    @Test
    public void basicRestTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "10");
        requestSpecification.basePath("/api/");
        requestSpecification.baseUri("https://randomuser.me/");

        Response response = requestSpecification.get();
        response.body().prettyPrint();

        SearchResults dto = response.as(SearchResults.class);
        System.out.println(dto.getResults().size());
        List<Person> persons = dto.getResults();

        for (Person person : persons) {
            System.out.println(person.getName().getFirst()
                    + " " + person.getName().getLast()
                    + ", " + person.getLocation().getCountry()
                    + ", " + person.getLocation().getCity()
                    + ", " + person.getNat()
            );

        }

        Assert.assertTrue(
                persons.stream().anyMatch(person -> person.getGender().equalsIgnoreCase("male")),
                "No male users generated!"
        );

    }

}
