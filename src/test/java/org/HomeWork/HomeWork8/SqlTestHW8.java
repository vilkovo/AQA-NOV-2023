package org.HomeWork.HomeWork8;

import HomeWork.HomeWork8.SearchResults;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import HomeWork.HomeWork8.Person;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SqlTestHW8 {

    private Connection connection;
    private Statement statement;

    @BeforeSuite
    public void setupDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //WARN: SQL connections wont work without this!
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void readSql() throws SQLException {
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery("SELECT * FROM Persons3");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("Title") + " " +
                                resultSet.getString("FirstName") + " " +
                                resultSet.getString("LastName") + " " +
                                resultSet.getString("City") + " " +
                                resultSet.getString("Country")
                );
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    @Test
    public void insertSql() throws SQLException {
        List<Person> persons = getPersons(3);
        if (persons.isEmpty()) {
            Assert.fail("No persons fetched!");
        }

        String sqlInsertPattern = "INSERT INTO Persons3 " +
                "(FirstName, LastName, Gender, Title, Nat, City, Country) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";

        for (Person dto : persons) {
            String sqlInsertWithValues = String.format(
                    sqlInsertPattern,
                    dto.getName().getFirst(),
                    dto.getName().getLast(),
                    dto.getGender(),
                    dto.getName().getTitle(),
                    dto.getNat(),
                    dto.getLocation().getCity(),
                    dto.getLocation().getCountry()
            );

            statement.execute(sqlInsertWithValues);
            System.out.println("SQL Insert is OK");
        }
    }

    private List<Person> getPersons(int amount) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", amount);
        requestSpecification.basePath("/api/");
        requestSpecification.baseUri("https://randomuser.me/");

        Response response = requestSpecification.get();
        response.body().prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        SearchResults dto = response.as(SearchResults.class);
        System.out.println(dto.getResults().size());
        return dto.getResults();
    }
}
