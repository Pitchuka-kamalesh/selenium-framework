package com.seleniumframework.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

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
            try{
                getDriver().quit();
            }catch (Throwable e){
                e.printStackTrace();
            }

        }
        threadLocal.remove();
    }


}
