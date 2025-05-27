package com.school.registration.service;

import com.school.registration.RegistrationApplication;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;

public abstract class AbstractAutofillRequest {
    // TODO Remove if not needed
    public static final int MAX_RETRY_COUNT = 3;
    public static final int TIMEOUT_IN_SECONDS = 60;
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    // TODO Remove if not needed
    public void acceptAlertIfPresent() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {}
    }

    public WebDriverWait initializeWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
    }

    public abstract void startAutofill() throws Exception;

    public abstract String getUserDirectory();

    public WebDriver initializeDriver() {
        String chromeDriverFilePath = Objects.requireNonNull(RegistrationApplication.class.getClassLoader().getResource("chromedriver")).getPath();
        System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--remote-allow-origins=*", getUserDirectory());
        /*
        // OPTIONS to consider if trying to login with Google. This is only needed to save progress. Else not needed.
        // Same goes for above "user directory option" - only needed if signing in by google
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
         */
        return new ChromeDriver(chromeOptions);
    }
}
