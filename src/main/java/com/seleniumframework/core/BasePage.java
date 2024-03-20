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


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void sendKeys(WebElement element,String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Timeouts.SHORT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }



    public void safeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(),Timeouts.SHORT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
