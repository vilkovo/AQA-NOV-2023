package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.elements.GoogleElements;

import java.time.Duration;

public class GoogleSteps {

    public static WebDriver webDriver;

    @Given("I load google page")
    public void loadGooglePage() {
        webDriver.get("https://google.com/");
    }

    @Given("I click on {}")
    public void clickOnElement(GoogleElements googleElement) {
        webDriver.findElement(googleElement.getLocator()).click();
    }

    @Given("I set {} value to {string}")
    public void setTextFieldValue(GoogleElements textField, String value) {
        webDriver.findElement(textField.getLocator()).sendKeys(value);
    }

    @Then("I see search at least {int} results with text {string}")
    public void checkResultsCount(int amount, String searchText) {
        String headerPartialText = String.format("//h3[contains(text(), '%s')]", searchText);
        new WebDriverWait(webDriver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath(headerPartialText), amount));
    }
}
