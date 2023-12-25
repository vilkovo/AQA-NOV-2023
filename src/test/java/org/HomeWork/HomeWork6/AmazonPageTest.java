package org.HomeWork.HomeWork6;

import HomeWork.HomeWork6.AmazonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonPageTest {
    private WebDriver driver;
    private AmazonPage amazonPage;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        amazonPage = new AmazonPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAmazonSearch() {
        amazonPage.loadPage();
        amazonPage.setSearchValue("iPhone 15 Pro");

        List<WebElement> searchHeaders = amazonPage.getSearchHeaders("iPhone 15 Pro");
        if (searchHeaders.size() >= 3) {
            System.out.println("iPhone 15 Pro is found!");
        }

        List<WebElement> searchHeaders2 = amazonPage.getSearchHeaders2("More Buying Choices");
        if (searchHeaders2.size() >= 2) {
            System.out.println("More Buying Choices is found!");
        }

        Assert.assertTrue(searchHeaders2.stream().anyMatch(
                        webElement -> webElement.getText().contains("More Buying Choices")),
                "ERROR");

    }

}

