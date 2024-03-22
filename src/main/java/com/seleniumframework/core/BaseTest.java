package com.seleniumframework.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

/**
 * Base test class for Selenium tests.
 * <p>
 * Provides setup and teardown methods for test suites, tests, classes, and methods.
 * </p>
 *
 * @see com.seleniumframework.core.PropertiesUtils
 * @see com.seleniumframework.core.TestUtils
 * @author Kamalesh
 * @version 1.0
 */
public class BaseTest {
    PropertiesUtils propertiesUtils;
    private static final Logger log = LogManager.getLogger(BaseTest.class.getName());

    /**
     * Executes before the entire test suite.
     */
    @BeforeSuite
    public synchronized void beforeSuite(){
        log.info("BaseTest.beforeSuit()");
        propertiesUtils = new PropertiesUtils();
        TestUtils.startBrowser();
    }
    /**
     * Executes before each test method.
     */
    @BeforeTest
    public synchronized void beforeTest(){
        log.info("BaseTest.beforeTest()");
    }
    /**
     * Executes before each test class.
     */
    @BeforeClass
    public synchronized void beforeClass(){
        log.info("BaseTest.beforeClass()");
    }
    /**
     * Executes before each test method.
     */
    @BeforeMethod
    public synchronized void beforeMethod(){
        log.info("BaseTest.beforeMethod");
    }
    /**
     * Executes after each test method.
     */
    @AfterTest
    public synchronized void afterTest(){
        log.info("BaseTest.afterTest()");
        log.info("inside afterTest() method");
    }
    /**
     * Executes after each test method.
     */
    @AfterMethod
    public synchronized void afterMethod(){
        log.info("BaseTest.afterMethod()");
    }
    /**
     * Executes after each test class.
     */
    @AfterClass
    public synchronized void afterClass(){log.info("BaseTest.afterClass()");}
    /**
     * Executes after the entire test suite.
     */
    @AfterSuite
    public synchronized void afterSuite(){log.info("BaseTest.afterSuite()");}


}
