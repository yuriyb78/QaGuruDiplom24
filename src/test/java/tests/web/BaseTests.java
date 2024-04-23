package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.web.config.DriverConfig;
import tests.web.helpers.Attach;

import java.util.Map;


public class BaseTests {

    @BeforeAll
    static void setUp() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        Configuration.browser = driverConfig.browserName();
        Configuration.browserVersion = driverConfig.browserVersion();
        Configuration.browserSize = driverConfig.browserSize();
        Configuration.remote = driverConfig.browserUrl();
        Configuration.baseUrl = "https://sokolov.ru";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true; // Чтобы браузер не закрывался после выполенения теста

        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

//        RestAssured.baseURI = "https://demoqa.com";

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Скриншот результата проверки");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }
}
