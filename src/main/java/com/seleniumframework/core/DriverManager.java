package com.seleniumframework.core;

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

    public static void closeWebDriver(){
        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        if (driver!=null){
            try {
               driver.close();
                ExtentReportManager.logInfoDetails("Closing the WebDriver");
            } catch (Throwable e){
                ExtentReportManager.logFailDetails(Arrays.toString(e.getStackTrace()));
            }
            if (driver.getSessionId() != null){
                try{
                    driver.quit();
                    ExtentReportManager.logInfoDetails("Quiting the WebDriver");
                }catch (Throwable e){
                    ExtentReportManager.logFailDetails(Arrays.toString(e.getStackTrace()));
                }
            }
        }
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadLocal.remove();
    }
    public static



}
