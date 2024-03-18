package com.seleniumframework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;


    // i must implements all the selenium common functions here.
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }


    /*
    sendKeys
    clear
    wait methods
     select method
     screenshot
     js
    Boarders

    */
}
