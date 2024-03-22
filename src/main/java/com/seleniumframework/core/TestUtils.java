package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import static com.seleniumframework.core.DriverManager.getDriver;


public class TestUtils {

    private static final Logger log = LogManager.getLogger(TestUtils.class.getName());
    /*
    * we have implemented the code for the test
    *
    *
    * */
    public static void startBrowser() {
        log.info("TestUtils.startBrowser()");
        DriverManager.setDriver(ThreadGuard.protect(DriverFactory.getBrowserDriver(PropertiesUtils.properties.getProperty("browser"))));
    }
    public static void launchApp(){
        log.info("TestUtils.launchApp() -> ");
        getDriver().manage().window().maximize();
        getDriver().get(PropertiesUtils.properties.getProperty("AppUrl"));
    }

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
