package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * A factory class for creating WebDriver instances for different browsers.
 * @author Kamalesh
 * @version 1.0
 */

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class.getName());
    /**
     * Gets a WebDriver instance for the specified browser.
     * @param browserName The name of the browser (e.g., "chrome", "firefox", "edge").
     * @return A WebDriver instance corresponding to the specified browser.
     * @throws IllegalStateException If an unexpected browser name is provided.
     */
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
    /**
     * Creates and returns a ChromeDriver instance.
     * @return A ChromeDriver instance.
     */
    private static WebDriver getChromeDriver() {
        log.info("DriverFactor.getChromeDriver()");
        return new ChromeDriver();
    }
    /**
     * Creates and returns an EdgeDriver instance.
     * @return An EdgeDriver instance.
     */
    private static WebDriver getEdgeDriver() {
        log.info("DriverFactor.getEdgeDriver()");
        return new EdgeDriver();
    }
    /**
     * Creates and returns a FirefoxDriver instance.
     * @return A FirefoxDriver instance.
     */
    private static WebDriver getFirefoxDriver() {
        log.info("DriverFactor.getFirefoxDriver()");
        return new FirefoxDriver();
    }

}
