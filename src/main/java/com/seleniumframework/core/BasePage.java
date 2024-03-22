package com.seleniumframework.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.seleniumframework.core.DriverManager.getDriver;

public class BasePage {
    // i must implements all the selenium common functions here.
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());

    public BasePage() {
        log.info("BasePage.BasePage()");
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForElement(WebElement element) {
        log.info("BasePage.waitForElement() -> {} ", Timeouts.SHORT_TIMEOUT);
        WebDriverWait wait = new WebDriverWait(getDriver(), Timeouts.SHORT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendKeys(WebElement element, String value) {
        waitForElement(element);
        log.info("BasePage.sendKeys() -> {} ", "Clearing the textBox");
        element.clear();
        log.info("BasePage.sendKeys() -> {} -> {} ", "sending the value to textBox", value);
        element.sendKeys(value);
    }

    public void safeClick(WebElement element) {
        waitForElement(element);
        log.info("BasePage.safeClick()");
        element.click();
    }

}
