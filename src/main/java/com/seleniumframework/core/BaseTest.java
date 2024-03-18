package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public void beforeSuite(){
        log.info("BaseTest.beforeSuit()");
    }
    @BeforeTest
    public void beforeTest(){
        log.info("BaseTest.beforeTest()");
    }
    @BeforeClass
    public void beforeClass(){
        log.info("BaseTest.beforeClass()");
    }
    @BeforeMethod
    public void beforeMethod(){
        log.info("BaseTest.beforeMethod");
    }
    @AfterTest
    public void afterTest(){
        log.info("BaseTest.afterTest()");
        log.info("inside afterTest() method");
    }
    @AfterMethod
    public void afterMethod(){
        log.info("BaseTest.afterTest()");
    }
    @AfterClass
    public void afterClass(){log.info("BaseTest.afterClass()");}
    @AfterSuite
    public void afterSuite(){log.info("BaseTest.afterSuite()");}


}
