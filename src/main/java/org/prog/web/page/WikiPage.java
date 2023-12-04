package org.prog.web.page;

import org.openqa.selenium.WebDriver;

public class WikiPage {

    private final WebDriver driver;

    public WikiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
