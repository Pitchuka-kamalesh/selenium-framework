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
        WebDriver driver = getDriver();
        if (driver!=null){
            try {
               driver.close();
            } catch (Throwable e){
                e.printStackTrace();
            }
            if (driver!=null){
                try{
                    driver.quit();
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
