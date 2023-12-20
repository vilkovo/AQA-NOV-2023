package HomeWork.HomeWork5;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonPageDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            AmazonPage amazonPage = new AmazonPage(driver);
            amazonPage.loadPage();
            amazonPage.setSearchValue("iPhone 15 Pro");
            amazonPage.performSearch();

            List<WebElement> searchHeaders = amazonPage.getSearchHeaders("iPhone 15 Pro");

            if (searchHeaders.size() >= 3) {
                System.out.println("iPhone 15 Pro is found!");
            }
        } finally {
            driver.quit();
        }
    }
}
