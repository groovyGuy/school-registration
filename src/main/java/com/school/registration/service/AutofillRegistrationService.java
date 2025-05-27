package com.school.registration.service;

import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.school.registration.util.ElementIdentifiers.*;
import static java.lang.System.exit;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
public class AutofillRegistrationService extends AbstractAutofillRequest {
    @Value("${school.website}")
    @NotBlank(message = "School website should be populated.")
    @Pattern(regexp = "/^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$/\n", message = "Invalid school website")
    private String url;

    @Value("${form.email}")
    private String email;

    @Value("${chrome.directory:IGNORED}")
    private String chromeDirectory;

    //@Value("#{'${my.list}'.split(',')}")
    //private List<String> myList;

    @Override
    public void startAutofill() {
        driver = initializeDriver();
        webDriverWait = initializeWebDriverWait();
        openSchoolHomepage();
        fillEmail();
        exit(0);
    }

    private void openSchoolHomepage() {
        driver.get(url);
        webDriverWait.until(elementToBeClickable(
                By.id(REGISTER_MENU_ID)
        )).click();
        //waitForGoogleLogin();
    }

    /**
     * This step is optional, so skipping now
     */
    /*private void waitForGoogleLogin() {
        webDriverWait.until(elementToBeClickable(
                By.linkText("Switch account")
        ));
    }*/

    public String getUserDirectory() {
        return "--user-data-dir=" + chromeDirectory;
    }

    private void fillEmail() {
        //webDriverWait.until(elementToBeClickable(By.xpath("(//input[@type='email'])[1]"))).click();
        //webDriverWait.until(elementToBeClickable(By.xpath("(//input[@type='email'])[1]"))).sendKeys(email);
    }
}
