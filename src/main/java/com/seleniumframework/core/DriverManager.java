package com.seleniumframework.core;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Arrays;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }

    public static synchronized void closeWebDriver(){
        RemoteWebDriver drivers = (RemoteWebDriver) getDriver();
        if (drivers!=null){
                try{
                    drivers.quit();
                    ExtentReportManager.logInfoDetails("Quiting the WebDriver");
                }catch (NoSuchSessionException e){
                    ExtentReportManager.logStacktrace(Arrays.toString(e.getStackTrace()));
                }
            }
        threadLocal.remove();
        }

    }


