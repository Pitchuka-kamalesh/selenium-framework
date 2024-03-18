package com.seleniumframework.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }

    public static void closeWebDriver(){
        if (getDriver()!=null){
            try {
                getDriver().close();
            } catch (Throwable e){
                e.printStackTrace();
            }
            if (getDriver()!=null){
                try{
                    getDriver().quit();
                }catch (Throwable e){
                    e.printStackTrace();
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



}
