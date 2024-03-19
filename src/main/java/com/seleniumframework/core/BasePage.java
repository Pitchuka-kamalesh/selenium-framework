package com.seleniumframework.core;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    // i must implements all the selenium common functions here.

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public static void sendKeys(WebElement element,int timeout,String value){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        element.sendKeys(value);
    }

    public static void clearKeys(WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        element.clear();

    }
    public static void safeClick(WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }




}
