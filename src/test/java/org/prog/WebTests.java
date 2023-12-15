package org.prog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.web.page.GooglePage;
import org.prog.web.page.WikiPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WebTests {

    private WebDriver driver;
    private GooglePage googlePage;
    private WikiPage wikiPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        wikiPage = new WikiPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeEach() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @Test(dataProvider = "celebrityNamesLuckySearch")
    public void testGoogleLuckySearch(String celebrity, String siteName) {
        googlePage.setSearchValue(celebrity);
        googlePage.feelingLucky();

        String url = wikiPage.getCurrentUrl();
        Assert.assertTrue(url.contains(siteName),
                String.format("Url '%s' does not contain symbols '%s'", url, siteName));
    }

    @Test(dataProvider = "celebrityNamesRegularSearch")
    public void testGoogleRegularSearch(String celebrity) {
        googlePage.setSearchValue(celebrity);
        googlePage.performSearch();
        List<WebElement> searchHeaders = googlePage.getSearchHeaders(celebrity);

        Assert.assertTrue(searchHeaders.stream().anyMatch(
                        webElement -> webElement.getText().contains(celebrity)),
                "Celebrity not found on google");
    }

    @DataProvider(name = "celebrityNamesLuckySearch")
    public Object[][] celebrityNamesLuckySearch() {
        return new Object[][]{
                {"Ben Affleck", "wikipedia"},
                {"nicole kidman", "wikipedia"},
                {"charlize theron", "wikipedia"},
                {"nicolas cage", "imdb"}
        };
    }

    @DataProvider(name = "celebrityNamesRegularSearch")
    public Object[][] celebrityNamesRegularSearch() {
        return new Object[][]{
                {"Ben Affleck"},
                {"Nicole Kidman"},
                {"Charlize Theron"},
                {"Nicolas Cage"}
        };
    }
}
