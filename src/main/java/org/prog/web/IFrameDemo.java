package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
            WebElement iframeExternal = driver.findElement(By.id("iframeResult"));
            driver.switchTo().frame(iframeExternal);
            WebElement innerFrame = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(innerFrame);
            WebElement element = driver.findElement(By.id("tnb-dark-mode-toggle-btn"));
            System.out.println(element.isDisplayed());

            driver.switchTo().defaultContent();

            WebElement runBtn = driver.findElement(By.id("runbtn"));
            System.out.println(runBtn.isDisplayed());
//
//
//            WebElement shadowRoot = driver.findElement(By.id("shadowRoot"));
//            SearchContext searchContext = shadowRoot.getShadowRoot();
//            WebElement element1 = searchContext.findElement(By.id("shadowContent"));
//            element1.click();
        } finally {
            driver.quit();
        }
    }
}
