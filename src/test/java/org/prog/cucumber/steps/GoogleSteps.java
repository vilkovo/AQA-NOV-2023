package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.elements.GoogleElements;
import org.prog.util.DataHolder;
import org.prog.web.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

public class GoogleSteps {

    public static WebDriver webDriver;

    @Autowired
    private DataHolder dataHolder;

    @Given("I load google page")
    public void loadGooglePage() {
        webDriver.get("about:blank");
        webDriver.get("https://google.com/");
    }

    @Given("I accept cookies if present")
    public void acceptCookies() {
        List<WebElement> cookieElement = webDriver.findElements(By.partialLinkText("cookie"));

        if (!cookieElement.isEmpty()) {
            WebElement cookiesLink = webDriver.findElement(By.partialLinkText("cookie"));

            if (cookiesLink.isDisplayed()) {
                System.out.println("Cookies form is shown!");
                List<WebElement> cookieFormButtons = webDriver.findElements(
                        By.xpath("//a[contains(text(),'cookie')]/../../../..//button"));
                cookieFormButtons.get(3).click();
            }
        } else {
            System.out.println("Cookie form not visible");
        }
    }

    @Given("I click on {}")
    public void clickOnElement(GoogleElements googleElement) {
        webDriver.findElement(googleElement.getLocator()).click();
    }

    @Given("I set {} value to {string}")
    public void setTextFieldValue(GoogleElements textField, String value) {
        webDriver.findElement(textField.getLocator()).sendKeys(value);
    }

    @Given("I set {} value to first last name of {string}")
    public void setSearchValueToRandomUserName(GoogleElements input, String alias) {
        setTextFieldValue(input, getPersonsFirstLastName(alias));
    }

    @Then("I see search at least {int} results with text {string}")
    public void checkResultsCount(int amount, String searchText) {
        String headerPartialText = String.format("//h3[contains(text(), '%s')]", searchText);
        new WebDriverWait(webDriver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath(headerPartialText), amount));
    }

    @Then("I see search at least {int} results with first last name of {string}")
    public void checkSearchResultsForRandomUser(int amount, String alias) {
        checkResultsCount(amount, getPersonsFirstLastName(alias));
    }

    private String getPersonsFirstLastName(String alias) {
        PersonDto person = (PersonDto) dataHolder.get(alias);
        return person.getName().getFirst() + " " + person.getName().getLast();
    }
}
