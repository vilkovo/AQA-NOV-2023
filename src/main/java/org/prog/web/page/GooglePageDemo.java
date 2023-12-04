package org.prog.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GooglePageDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        GooglePage googlePage = new GooglePage(driver);
        WikiPage wikiPage = new WikiPage(driver);

        try {
            googlePage.loadPage();
            googlePage.acceptCookiesIfPresent();

            googlePage.setSearchValue("Ben Affleck");
            googlePage.feelingLucky();
            System.out.println("lucky!");

            String url = wikiPage.getCurrentUrl();
            System.out.println("https://sv.wikipedia.org/wiki/Ben_Affleck".equals(url));

//            List<WebElement> searchHeaders = googlePage.getSearchHeaders("Ben Affleck");
//
//            if (searchHeaders.size() >= 3) {
//                System.out.println("Ben Affleck is found!");
//            }
        } finally {
            driver.quit();
        }
    }
}
