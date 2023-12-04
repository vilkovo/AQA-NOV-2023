package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class SeleniumDemo {

    private static HashMap<String, String> windwosRegister = new HashMap<>();

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://google.com/");

            WebElement cookiesLink = driver.findElement(By.partialLinkText("cookie"));

            if (cookiesLink.isDisplayed()) {
                System.out.println("Cookies form is shown!");
                List<WebElement> cookieFormButtons = driver.findElements(
                        By.xpath("//a[contains(text(),'cookie')]/../../../..//button"));
                cookieFormButtons.get(3).click();
            }

            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("Ben Affleck");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchHeaders = new WebDriverWait(driver, Duration.ofSeconds(30L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                            By.xpath("//h3[contains(text(), 'Ben Affleck')]"), 3));

            if (searchHeaders.size() >= 3) {
                System.out.println("Ben Affleck is found!");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
