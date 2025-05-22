package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browser.version", "128.0");
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}