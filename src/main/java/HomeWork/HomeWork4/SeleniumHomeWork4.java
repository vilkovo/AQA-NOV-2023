package HomeWork.HomeWork4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHomeWork4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com/");

            WebElement searchInput = driver.findElement(By.name("field-keywords"));
            searchInput.sendKeys("iPhone 15 Pro");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchHeaders = new WebDriverWait(driver, Duration.ofSeconds(30L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                            By.xpath("//span[contains(text(), 'iPhone 15 Pro')]"), 3));

            if (searchHeaders.size() >= 3) {
                System.out.println("iPhone 15 Pro is found!");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
