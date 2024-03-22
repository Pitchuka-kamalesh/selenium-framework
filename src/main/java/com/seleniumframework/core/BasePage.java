package com.seleniumframework.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.seleniumframework.core.DriverManager.getDriver;
/**
 * Base class for page objects containing common Selenium functions.
 */
public class BasePage {
    // i must implements all the selenium common functions here.
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());
    /**
     * Initializes the page elements using PageFactory.
     */
    public BasePage() {
        log.info("BasePage.BasePage()");
        PageFactory.initElements(getDriver(), this);
    }
    /**
     * Waits for the visibility of a WebElement.
     *
     * @param element The WebElement to wait for.
     */
    public void waitForElement(WebElement element) {
        log.info("BasePage.waitForElement() -> {} ", Timeouts.SHORT_TIMEOUT.toString());
        WebDriverWait wait = new WebDriverWait(getDriver(), Timeouts.SHORT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Clears the text box and sends keys to it.
     *
     * @param element The WebElement representing the text box.
     * @param value   The value to send to the text box.
     */
    public void sendKeys(WebElement element, String value) {
        waitForElement(element);
        log.info("BasePage.sendKeys() -> {} ", "Clearing the textBox");
        element.clear();
        log.info("BasePage.sendKeys() -> {} -> {} ", "sending the value to textBox", value);
        element.sendKeys(value);
    }
    /**
     * Safely clicks on a WebElement after waiting for it to be clickable.
     *
     * @param element The WebElement to click on.
     */
    public void safeClick(WebElement element) {
        waitForElement(element);
        log.info("BasePage.safeClick()");
        element.click();
    }

}
