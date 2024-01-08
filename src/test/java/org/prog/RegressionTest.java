package org.prog;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegressionTest extends BaseTest {

    @AfterSuite
    public void beforeAll() {
        System.out.println("====END_AUTOMATED_RUN====");
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("=====START_BASE_TEST=====");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void myTest() {
        printSomething("test 1");
        printSomething2("test 1");
        printSomething3("test 1");
        printSomething4("test 1");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void myAnotherTest() {
        printSomething("test 2");
        printSomething2("test 2");
        printSomething3("test 2");
        printSomething4("test 2");
    }

    @Step("I am using method 1 to print {s}")
    private void printSomething(String s){
        System.out.println(s);
    }

    @Step("I am using method 2 to print {s}")
    private void printSomething2(String s){
        System.out.println(s);
    }

    @Step("I am using method 3 to print {s}")
    private void printSomething3(String s){
        System.out.println(s);
    }

    @Step("I am using method 4 to print {s}")
    private void printSomething4(String s){
        System.out.println(s);
    }
}
