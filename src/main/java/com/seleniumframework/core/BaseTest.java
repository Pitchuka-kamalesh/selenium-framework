package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public synchronized void beforeSuite(){
        log.info("BaseTest.beforeSuit()");
        TestUtils.startBrowser();
        PropertiesUtils propertiesUtils = new PropertiesUtils();
        TestUtils.startBrowser();
    }
    @BeforeTest
    public synchronized void beforeTest(){
        log.info("BaseTest.beforeTest()");
        TestUtils.launchApp();
    }
    @BeforeClass
    public synchronized void beforeClass(){
        log.info("BaseTest.beforeClass()");
    }
    @BeforeMethod
    public synchronized void beforeMethod(){
        log.info("BaseTest.beforeMethod");
    }
    @AfterTest
    public synchronized void afterTest(){
        log.info("BaseTest.afterTest()");
        log.info("inside afterTest() method");
    }
    @AfterMethod
    public synchronized void afterMethod(){
        log.info("BaseTest.afterMethod()");
    }
    @AfterClass
    public synchronized void afterClass(){log.info("BaseTest.afterClass()");}
    @AfterSuite
    public synchronized void afterSuite(){log.info("BaseTest.afterSuite()");}


}
