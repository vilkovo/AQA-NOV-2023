package org.prog.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum GoogleElements {
    GOOGLE_ACCEPT_COOKIES(By.xpath("//a[contains(text(),'cookie')]/../../../..//button[@id='L2AGLb']")),
    GOOGLE_LOGO(By.xpath("//img[@alt='Google']")),
    GOOGLE_SEARCH_INPUT(By.name("q")),
    GOOGLE_SEARCH_BTN(By.xpath("(//*[@name='btnK'])[2]"));

    private By locator;

    GoogleElements(By locator) {
        this.locator = locator;
    }

    public By getLocator(){
        return this.locator;
    }

    public void printStuff() {
        System.out.println("This is enum method!");
    }
}
