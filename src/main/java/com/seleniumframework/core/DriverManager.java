package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class DriverManager {
    private static final Logger log = LogManager.getLogger(DriverManager.class.getName());
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        log.info("DriverManager.getDriver()");
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        log.info("DriverManager.setDriver()");
        threadLocal.set(driver);
    }
    public static void releaseDriver(){
        log.info("DriverManager.releaseDriver()");
        threadLocal.remove();
    }

    public static synchronized void closeWebDriver(){
        WebDriver drivers = getDriver();
        if (drivers!=null){
                try{
                    ExtentReportManager.logInfoDetails("Quiting the WebDriver");
                    drivers.quit();
                }catch (NoSuchSessionException e){
                    ExtentReportManager.logStacktrace(Arrays.toString(e.getStackTrace()));
                }
            }
        }



}




