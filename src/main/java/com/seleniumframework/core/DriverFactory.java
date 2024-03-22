package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class.getName());
    public static WebDriver getBrowserDriver(String browserName) {
        log.info("DriverFactory.getBrowserDriver()");
        switch (browserName.toLowerCase()) {
            case "chrome":
                return getChromeDriver();

            case "edge":
                return getEdgeDriver();

            case "firefox":
                return getFirefoxDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
    }

    private static WebDriver getChromeDriver() {
        log.info("DriverFactor.getChromeDriver()");
        return new ChromeDriver();
    }

    private static WebDriver getEdgeDriver() {
        log.info("DriverFactor.getEdgeDriver()");
        return new EdgeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        log.info("DriverFactor.getFirefoxDriver()");
        return new FirefoxDriver();
    }

}
