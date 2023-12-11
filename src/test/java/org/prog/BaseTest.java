package org.prog;

import org.testng.annotations.AfterMethod;

public class BaseTest {

    @AfterMethod
    public void afterTest() {
        System.out.println("=====AFTER_EVERY_TEST=====");
    }
}
