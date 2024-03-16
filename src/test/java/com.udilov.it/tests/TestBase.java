package com.udilov.it.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.udilov.it.attachments.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import com.udilov.it.config.DriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;


public class TestBase {

    @BeforeAll
    static void beforeAll() {

        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browser_size", driverConfig.browserSize());
        Configuration.browser = System.getProperty("browser", driverConfig.browserName());
        Configuration.browserVersion = System.getProperty("browser_version", driverConfig.browserVersion());
        Configuration.timeout = 6000;
        Configuration.remote = System.getProperty("browser_remote_url");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {

        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        if (!Objects.equals(Configuration.browser, "firefox")) {
            Attachments.browserConsoleLogs();
        }

        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}
