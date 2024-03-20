package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtils {
    private static final Logger log = LogManager.getLogger(TestUtils.class.getName());
    /*
    * we have implemented the code for the test
    *
    *
    * */

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
