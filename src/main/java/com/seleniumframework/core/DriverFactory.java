package com.seleniumframework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public DriverFactory(){

    }
    public static WebDriver getDriver(String browserName) throws Throwable {

        switch (browserName.toLowerCase()) {
            case "chrome":
                return getChromeDriver();

            case "edge":
                return getEdgeDriver();

            case "firefox":
                return getFireFoxDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
    }

    private static WebDriver getChromeDriver() {

        return new ChromeDriver();
    }

    private static WebDriver getEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }

}
