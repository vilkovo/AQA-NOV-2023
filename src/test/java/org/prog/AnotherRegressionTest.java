package org.prog;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnotherRegressionTest extends BaseTest {

    @BeforeSuite
    public void beforeAll() {
        System.out.println("====START_AUTOMATED_RUN====");
    }

    @BeforeMethod
    public void beforeTest() {
        System.out.println("=====START_ADV_TEST=====");
    }

    @Test
    public void myTest() {
        System.out.println("Hello Test!");
    }

    @Test
    public void myAnotherTest() {
        System.out.println("Hello Test!");
    }

    @DataProvider(name = "values")
    public Object[][] dataProvider() {
        return new Object[][] {
                {"Value 1", "Output 1"},
                {null, "Output 2"},
                {"Value 3", "Output 3"}
        };
    }
}
