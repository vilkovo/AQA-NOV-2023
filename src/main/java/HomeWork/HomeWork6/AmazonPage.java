package HomeWork.HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonPage {
    private final WebDriver driver;
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }
    public void loadPage() {
        driver.get("https://www.amazon.com/");
    }
    public void setSearchValue(String searchValue) {
        WebElement searchInput = driver.findElement(By.name("field-keywords"));
        searchInput.sendKeys(searchValue);
        searchInput.sendKeys(Keys.ENTER);
    }
    public List<WebElement> getSearchHeaders(String withValue) {
        String headerPartialText = String.format("//span[contains(text(), '%s')]", withValue);
        return new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath(headerPartialText), 3));
    }
    public List<WebElement> getSearchHeaders2(String withValue) {
        String headerPartialText = String.format("//span[contains(text(), '%s')]", withValue);
        return new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath(headerPartialText), 3));
    }
}
