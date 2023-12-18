package org.prog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.prog.web.dto.PersonDto;
import org.prog.web.dto.SearchResultsDto;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SqlTest {

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
            resultSet = statement.executeQuery("SELECT * FROM Persons");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("Title") + " " +
                                resultSet.getString("FirstName") + " " +
                                resultSet.getString("LastName")
                );
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    @Test
    public void insertSql() throws ClassNotFoundException, SQLException {
        List<PersonDto> persons = getPersons(3);
        if (persons.isEmpty()) {
            Assert.fail("No persons fetched!");
        }

        String sqlInsertPattern = "INSERT INTO Persons " +
                "(FirstName, LastName, Gender, Title, Nat) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s')";

        for (PersonDto dto : persons) {
            String sqlInsertWithValues = String.format(
                    sqlInsertPattern,
                    dto.getName().getFirst(),
                    dto.getName().getLast(),
                    dto.getGender(),
                    dto.getName().getTitle(),
                    dto.getNat()
            );

            statement.execute(sqlInsertWithValues);
            System.out.println("SQL Insert is OK");
        }
    }

    private List<PersonDto> getPersons(int amount) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", amount);
        requestSpecification.basePath("/api/");
        requestSpecification.baseUri("https://randomuser.me/");

        Response response = requestSpecification.get();
        response.body().prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        SearchResultsDto dto = response.as(SearchResultsDto.class);
        System.out.println(dto.getResults().size());
        return dto.getResults();
    }
}
