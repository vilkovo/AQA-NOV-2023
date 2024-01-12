package org.prog.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.prog.cucumber.steps.GoogleSteps;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@EnableTransactionManagement
@EnableJpaRepositories("org.prog")
@CucumberContextConfiguration
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
@CucumberOptions(
        features = "src/test/resources/features/wip",
        glue = "org.prog.cucumber",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        AbstractDriverOptions options;
        if (System.getProperty("browser.type").equals("chrome")) {
            options = chromeOptions();
        } else {
            options = firefoxOptions();
        }
        String platform = System.getProperty("platform.type");

        switch (platform) {
            case "local-selenoid":
                GoogleSteps.webDriver =
                        new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                break;
            case "jenkins-selenoid":
                GoogleSteps.webDriver =
                        new RemoteWebDriver(new URL("http://selenoid-selenoid-1:4444/wd/hub"), options);
                break;
            default:
                GoogleSteps.webDriver = new ChromeDriver();
        }
    }

    @AfterSuite
    public void tearDown() {
        GoogleSteps.webDriver.quit();
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        updateOptions(options);
        return options;
    }

    private FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        updateOptions(options);
        return options;
    }

    private void updateOptions(AbstractDriverOptions options) {
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
    }
}
