package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import static com.seleniumframework.core.DriverManager.getDriver;

/**
 * Utility class for common test operations.
 * @author Kamalesh
 * @version 1.0
 */
public class TestUtils {

    private static final Logger log = LogManager.getLogger(TestUtils.class.getName());
    /**
     * Starts the browser and sets the WebDriver instance.
     */
    public static void startBrowser() {
        log.info("TestUtils.startBrowser()");
        DriverManager.setDriver(ThreadGuard.protect(DriverFactory.getBrowserDriver(PropertiesUtils.getProperties().getProperty("browser"))));
    }
    /**
     * Launches the application by maximizing the window and navigating to the specified URL.
     */
    public static void launchApp(){
        log.info("TestUtils.launchApp() -> ");
        getDriver().manage().window().maximize();
        getDriver().get(PropertiesUtils.getProperties().getProperty("AppUrl"));
    }
    /**
     * Takes a screenshot and returns it as a Base64 encoded string.
     *
     * @param driver The WebDriver instance.
     * @return A Base64 encoded string representing the screenshot.
     */
    public static String takeScreenshotAsBase64(WebDriver driver){
        log.info("TestUtils.takeScreenshotAsBase64()");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            log.error(e.getCause());
        }
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
}
