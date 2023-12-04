package org.prog.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://google.com/");
    }

    public void acceptCookiesIfPresent() {
        WebElement cookiesLink = driver.findElement(By.partialLinkText("cookie"));

        if (cookiesLink.isDisplayed()) {
            System.out.println("Cookies form is shown!");
            List<WebElement> cookieFormButtons = driver.findElements(
                    By.xpath("//a[contains(text(),'cookie')]/../../../..//button"));
            cookieFormButtons.get(3).click();
        }
    }

    public void setSearchValue(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(searchValue);
    }

    public void performSearch() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(Keys.ENTER);
    }

    public void feelingLucky() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.click();
        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[@role='listbox']/li")));
        List<WebElement> searchButtons = driver.findElements(By.xpath("//form//input"));
        searchButtons.get(1).click();
    }

    public List<WebElement> getSearchHeaders(String withValue) {
        String headerPartialText = String.format("//h3[contains(text(), '%s')]", withValue);
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath(headerPartialText), 3));
    }
}
