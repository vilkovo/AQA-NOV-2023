package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.prog.util.DataHolder;
import org.prog.web.dto.NameDto;
import org.prog.web.dto.PersonDto;
import org.testng.Assert;

import java.sql.*;
import java.util.List;

public class DBSteps {

    private Connection connection;
    private Statement statement;

    @Given("I store {string} users to DB")
    public void storeusersToDB(String alias) throws SQLException, ClassNotFoundException {
        List<PersonDto> persons = (List<PersonDto>) DataHolder.getInstance().get(alias);
        if (persons == null || persons.isEmpty()) {
            Assert.fail("No persons fetched! Please refer RestSteps for 'requestUsersFromService' method");
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

            try {
                setupDbConnection();
                statement.execute(sqlInsertWithValues);
            } finally {
                tearDown();
            }
        }
    }

    @Given("I retrieve a random user from DB as {string}")
    public void retrieveRandomUser(String alias) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        try {
            setupDbConnection();
            resultSet = statement.executeQuery("SELECT * FROM Persons ORDER BY RAND() LIMIT 1");
            if (resultSet.next()) {
                DataHolder.getInstance().put(alias,
                        PersonDto.builder()
                                .nat(resultSet.getString("Nat"))
                                .gender(resultSet.getString("Gender"))
                                .name(NameDto.builder()
                                        .first(resultSet.getString("FirstName"))
                                        .last(resultSet.getString("LastName"))
                                        .title(resultSet.getString("Title"))
                                        .build())
                                .build())
                ;
            } else {
                Assert.fail("No users present in DB!");
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            tearDown();
        }
    }

    public void setupDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //WARN: SQL connections wont work without this!
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }

    public void tearDown() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
