package com.seleniumframework.core;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }
    public static void releaseWebDriver(){
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


