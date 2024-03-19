package com.seleniumframework.core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.seleniumframework.core.DriverManager.getDriver;

public class BasePage {
    // i must implements all the selenium common functions here.

    private final JavascriptExecutor javaScript;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
        this.javaScript = (JavascriptExecutor) getDriver();
    }

    public void sendKeys(WebElement element, int timeout, String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightElement(element);
        element.sendKeys(value);
    }

    public void clearKeys(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element);
        element.clear();

    }

    public void safeClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element);
        element.click();
    }


    public void highlightElement(WebElement element) {
        javaScript.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    }


}
