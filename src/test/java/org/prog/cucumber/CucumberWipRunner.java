package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.GoogleSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/features/wip",
        glue = "org.prog.cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        }
)
public class CucumberWipRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        GoogleSteps.webDriver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        GoogleSteps.webDriver.quit();
    }
}
