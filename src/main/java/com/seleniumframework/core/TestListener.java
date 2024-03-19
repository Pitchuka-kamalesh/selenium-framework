package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class.getName());
    public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extentReport;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName  :" + result.getMethod().getMethodName());
        extentTest.set(test);

    }


    @Override
    public void onTestFailure(ITestResult result) {
        log.error(result.getThrowable().getMessage());
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        log.error(result.getThrowable().getStackTrace());
        ExtentReportManager.logStacktrace(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onStart(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browserName");
        log.info(browser);
        extentReport = ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(), "TestApiAutomaction", "Api Testing");
        log.info("Starting the Browser and loading the data  it is running which method");
        DriverManager.setDriver(ThreadGuard.protect(DriverFactory.getBrowserDriver(browser)));
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverManager.closeWebDriver();
        DriverManager.releaseWebDriver();
        if (extentReport != null) {
            extentReport.flush();
        }

    }

    // i have to implements all the common reports and logging and retry mech
}
